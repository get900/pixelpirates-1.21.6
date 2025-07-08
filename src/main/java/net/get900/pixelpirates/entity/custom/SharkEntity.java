package net.get900.pixelpirates.entity.custom;

import net.get900.pixelpirates.entity.goal.SharkAttackGoal;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;

import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.SwimNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.fluid.Fluids;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.animation.AnimationState;

import java.util.Comparator;

public class SharkEntity extends PathAwareEntity implements GeoEntity {
    private static final RawAnimation IDLE_ANIMATION =
            RawAnimation.begin().thenLoop("animation.shark.idle_animation");

    private float idleSpeed = 0.1f;
    private float chaseSpeed = 0.25f;

    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public SharkEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new MoveControl(this);
        this.setPathfindingPenalty(PathNodeType.WATER, 0.0F);
        this.setTarget(null); // clear any old target
        this.setPersistent(); // so it doesn’t despawn
        this.orbitPhaseOffset = this.random.nextDouble() * Math.PI * 2;
    }

    @Nullable
    private RaftEntity getNearestRaft(double radius) {
        return this.getWorld()
                .getEntitiesByClass(RaftEntity.class, this.getBoundingBox().expand(radius), raft -> true)
                .stream()
                .min(Comparator.comparingDouble(this::distanceTo))
                .orElse(null);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return PathAwareEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.2)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 80.0);
    }

    @Override
    protected void initGoals() {
        // Idle movement
        this.goalSelector.add(1, new SwimAroundGoal(this, 1.0, 10));

        // Modular swooping logic against players (can expand later)
        this.goalSelector.add(2, new SharkAttackGoal(this));

        // Only target players, and only if they are in water
        this.targetSelector.add(1, new ActiveTargetGoal<>(
                this,
                PlayerEntity.class,
                10,
                true,
                false,
                player -> player.isTouchingWater()
        ));
    }


    @Override
    protected EntityNavigation createNavigation(World world) {
        return new SwimNavigation(this, world); // allows water pathfinding
    }

    @Override
    public void tick() {
        super.tick();

        // Never drown
        if (this.isInsideWaterOrBubbleColumn()) {
            this.setAir(this.getMaxAir());
        }

        if (!this.getWorld().isClient) {
            // 🎯 Priority: orbit the nearest raft
            RaftEntity targetRaft = getNearestRaft(64);
            if (targetRaft != null) {
                orbitAround(targetRaft, 6.0, idleSpeed);
                maybeLeapOut();
                return;
            }

            // 🤿 Otherwise, attacking is handled by SharkAttackGoal
            maybeLeapOut(); // allow idle jumping
        }
    }

    private void maybeLeapOut() {
        if (this.isTouchingWater() && this.getRandom().nextInt(600) == 0) {
            this.addVelocity(0, 0.6 + this.getRandom().nextDouble() * 0.4, 0);
            this.velocityDirty = true;
            this.playSound(SoundEvents.ENTITY_DOLPHIN_JUMP, 1.0F, 1.0F);
        }
    }

    public void orbitAround(Entity target, double radius, float turnSpeed) {
        double time = this.age + orbitPhaseOffset;

        double angle = (time % 360) * 0.05;
        double offsetX = Math.cos(angle) * radius;
        double offsetZ = Math.sin(angle) * radius;

// Bobbing with independent vertical offset
        double seaY = this.getWorld().getSeaLevel() - 1 + Math.sin(time * 0.1) * 0.3;

        Vec3d orbitPos = new Vec3d(target.getX() + offsetX, seaY, target.getZ() + offsetZ);

        Vec3d direction = orbitPos.subtract(this.getPos()).normalize();
        double yaw = Math.toDegrees(Math.atan2(-direction.x, direction.z));
        float currentYaw = this.getYaw();
        float newYaw = (float) yaw;
        float smoothedYaw = currentYaw + (MathHelper.wrapDegrees(newYaw - currentYaw) * 0.1f);
        this.setYaw(smoothedYaw);
        this.setBodyYaw(smoothedYaw);

        Vec3d forward = this.getRotationVector().normalize().multiply(orbitSpeed);
        this.setVelocity(forward);
        this.move(MovementType.SELF, forward);
    }

    private float orbitSpeed = 0.08f + this.random.nextFloat() * 0.04f; // range 0.08–0.12


    @Override
    public boolean isPushedByFluids() {
        return false;
    }

    // GeckoLib animation setup
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private <T extends GeoEntity> PlayState predicate(AnimationState<T> state) {
        Vec3d velocity = this.getVelocity();
        boolean isMoving = velocity.horizontalLengthSquared() > 0.001;

        if (isMoving && this.isTouchingWater()) {
            return state.setAndContinue(IDLE_ANIMATION); // play idle swim animation
        }

        return PlayState.STOP;
    }

    private double orbitPhaseOffset = 0;

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
    }

    @Override
    protected SoundEvent getSwimSound() {
        return SoundEvents.ENTITY_DOLPHIN_SWIM; // or your custom shark sound
    }

    public float getIdleSpeed() {
        return 0.1f;
    }

    public float getChaseSpeed() {
        return 0.25f;
    }

}


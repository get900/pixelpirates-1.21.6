package net.get900.pixelpirates.entity.goal;

import net.get900.pixelpirates.entity.custom.SharkEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

import java.util.EnumSet;

public class SharkAttackGoal extends Goal {
    private final SharkEntity shark;
    private LivingEntity target;
    private int cooldown = 0;

    public SharkAttackGoal(SharkEntity shark) {
        this.shark = shark;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        LivingEntity potential = shark.getTarget();
        return potential instanceof net.minecraft.entity.player.PlayerEntity && potential.isTouchingWater();
    }

    @Override
    public void start() {
        this.target = shark.getTarget();
    }

    @Override
    public void tick() {
        if (target == null || !target.isAlive()) return;

        if (cooldown > 0) {
            cooldown--;
            return;
        }

        Vec3d toTarget = target.getPos().subtract(shark.getPos());
        double distance = toTarget.length();
        Vec3d direction = toTarget.normalize();

        // Smooth yaw turning
        double targetYaw = Math.toDegrees(Math.atan2(-direction.x, direction.z));
        float smoothedYaw = shark.getYaw() + MathHelper.wrapDegrees((float) targetYaw - shark.getYaw()) * 0.1f;
        shark.setYaw(smoothedYaw);
        shark.setBodyYaw(smoothedYaw);

        // Always charge forward
        float speed = shark.getChaseSpeed();
        Vec3d velocity = direction.multiply(speed);
        shark.setVelocity(velocity);
        shark.move(MovementType.SELF, velocity);

        // Bite if close enough
        if (shark.distanceTo(target) < 2.5f) {
            shark.tryAttack(target);
            cooldown = 40 + shark.getRandom().nextInt(60); // Wait 2–5s before another swoop
        }
    }
}

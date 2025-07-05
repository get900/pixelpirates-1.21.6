package net.get900.pixelpirates.entity.custom;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.get900.pixelpirates.item.ModItems;

public class DynamiteEntity extends ThrownItemEntity {

    public DynamiteEntity(EntityType<? extends ThrownItemEntity> type, World world) {
        super(type, world);
    }

    public DynamiteEntity(EntityType<? extends ThrownItemEntity> type, World world, LivingEntity owner) {
        super(type, owner, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.DYNAMITE;
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        if (!this.getWorld().isClient) {
            explode();
            this.discard();
        }
    }

    private void explode() {
        this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 2.0f, World.ExplosionSourceType.MOB); // Half TNT power (TNT is 4.0f)
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
    }
}

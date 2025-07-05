package net.get900.pixelpirates.item.custom;

import net.get900.pixelpirates.entity.ModEntities;
import net.get900.pixelpirates.entity.custom.DynamiteEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class DynamiteItem extends Item {
    public DynamiteItem(Settings settings) {
        super(settings);
    }

    public int getMaxUseTime(ItemStack stack) {
        return 40; // 2 seconds
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return TypedActionResult.consume(user.getStackInHand(hand));
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        return stack; // not used here
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!(user instanceof PlayerEntity player)) return;

        int charge = this.getMaxUseTime(stack) - remainingUseTicks;
        float power = MathHelper.clamp(charge / 20f, 0.3f, 1.0f);

        if (!world.isClient) {
            DynamiteEntity dynamite = new DynamiteEntity(ModEntities.DYNAMITE, world, player);
            dynamite.setVelocity(player, player.getPitch(), player.getYaw(), 0.0f, power * 1.5f, 1.0f);
            world.spawnEntity(dynamite);
        }

        world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.PLAYERS, 0.6f, 1.2f);
        if (!player.getAbilities().creativeMode) {
            stack.decrement(1);
        }
    }
}

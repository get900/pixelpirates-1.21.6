package net.get900.pixelpirates.item.custom;

import net.get900.pixelpirates.entity.ModEntities;
import net.get900.pixelpirates.entity.custom.RaftEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;

public class RaftItem extends Item {

    public RaftItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        Hand hand = context.getHand();

        if (!world.isClient && player != null) {
            RaftEntity raft = new RaftEntity(ModEntities.RAFT, world);

            double x = player.getX();
            double y = player.getY() + 1.0; // ✅ one block above player
            double z = player.getZ();

            raft.refreshPositionAndAngles(x, y, z, player.getYaw(), 0.0f);
            world.spawnEntity(raft);

            if (!player.getAbilities().creativeMode) {
                context.getStack().decrement(1);
            }
        }

        return ActionResult.SUCCESS;
    }
}

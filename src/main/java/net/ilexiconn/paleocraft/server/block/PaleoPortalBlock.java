package net.ilexiconn.paleocraft.server.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class PaleoPortalBlock extends BlockBreakable {
    public PaleoPortalBlock() {
        super(Material.PORTAL, false);
        this.setUnlocalizedName("paleocraft.portal");
        this.setBlockUnbreakable();
        this.setTickRandomly(true);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
        if (!entity.isRiding() && !entity.isBeingRidden() && entity.isNonBoss()) {
            entity.addChatMessage(new TextComponentString("Whoosh"));
        }
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World world, BlockPos pos) {
        return Block.NULL_AABB;
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return null;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
}

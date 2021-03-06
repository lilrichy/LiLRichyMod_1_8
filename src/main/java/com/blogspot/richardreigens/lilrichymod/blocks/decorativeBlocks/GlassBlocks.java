package com.blogspot.richardreigens.lilrichymod.blocks.decorativeBlocks;

import com.blogspot.richardreigens.lilrichymod.creativeTab.CreativeTabLiLRichyMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;

/**
 * Created by LiLRichy on 1/26/2016.
 */
public class GlassBlocks extends DecoSubBlocks {
    //Constructor with Tool tip
    public GlassBlocks(String name, Material material, String toolTip, String toolTip2, String[] types, int typesLength) {
        super(name, material, toolTip, toolTip2, types, typesLength);
        this.setHardness(0.5f);
        this.setLightLevel(1.0F);
        this.setStepSound(soundTypeGlass);
        this.setCreativeTab(CreativeTabLiLRichyMod.LR_Tab);
        this.setUnlocalizedName(name);
    }
    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    public boolean shouldSideBeRendered1(IBlockAccess world, BlockPos pos, EnumFacing side) {
        Block block = world.getBlockState(pos).getBlock();

        return block == this ? false : super.shouldSideBeRendered(world, pos, side);
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess world, BlockPos pos, EnumFacing side) {
        return shouldSideBeRendered1(world, pos, side.getOpposite());
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }
}

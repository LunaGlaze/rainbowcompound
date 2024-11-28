package com.LunaGlaze.rainbowcompound.Projects.Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;


public class RefinedRadianceNeon extends RotatedPillarBlock {

    public static VoxelShape shape = Block.box(6,0,6,10,16,10);
    public static VoxelShape shapex = Block.box(0,6,6,16,10,10);
    public static VoxelShape shapez = Block.box(6,6,0,10,10,16);


    public RefinedRadianceNeon() {
        super(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.8F,4F).sound(SoundType.GLASS)
                .lightLevel((p_152686_) -> {return 14;}));
    }

    public @NotNull VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        switch (pState.getValue(AXIS)){
            case X:
                return shapex;
            case Z:
                return shapez;
            default:
                return shape;
        }
    }

}

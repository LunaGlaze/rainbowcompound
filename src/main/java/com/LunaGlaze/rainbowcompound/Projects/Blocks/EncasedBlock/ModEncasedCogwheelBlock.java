package com.LunaGlaze.rainbowcompound.Projects.Blocks.EncasedBlock;

import com.LunaGlaze.rainbowcompound.Projects.TileEntities.EncasedTileEntities;
import com.simibubi.create.content.contraptions.ITransformableBlock;
import com.simibubi.create.content.decoration.encasing.EncasedBlock;
import com.simibubi.create.content.kinetics.simpleRelays.ICogWheel;
import com.simibubi.create.content.kinetics.simpleRelays.SimpleKineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogwheelBlock;
import com.simibubi.create.content.schematics.requirement.ISpecialBlockItemRequirement;
import com.simibubi.create.foundation.block.IBE;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public class ModEncasedCogwheelBlock extends EncasedCogwheelBlock
        implements ICogWheel, IBE<SimpleKineticBlockEntity>, ISpecialBlockItemRequirement, ITransformableBlock, EncasedBlock {

    public static final BooleanProperty TOP_SHAFT = BooleanProperty.create("top_shaft");
    public static final BooleanProperty BOTTOM_SHAFT = BooleanProperty.create("bottom_shaft");
    boolean isLarge;
    private final Supplier<Block> casing;

    public ModEncasedCogwheelBlock(Properties properties, boolean large, Supplier<Block> casing) {
        super(properties, large, casing);
        isLarge = large;
        this.casing = casing;
        registerDefaultState(defaultBlockState().setValue(TOP_SHAFT, false)
                .setValue(BOTTOM_SHAFT, false));
    }

    @Override
    public BlockEntityType<? extends SimpleKineticBlockEntity> getBlockEntityType() {
        return isLarge ? EncasedTileEntities.ENCASED_LARGE_COGWHEEL.get() : EncasedTileEntities.ENCASED_COGWHEEL.get();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean skipRendering(BlockState selfState, BlockState adjacentBlock, Direction side) {
        return adjacentBlock.getBlock() instanceof ModEncasedCogwheelBlock;
    }
}

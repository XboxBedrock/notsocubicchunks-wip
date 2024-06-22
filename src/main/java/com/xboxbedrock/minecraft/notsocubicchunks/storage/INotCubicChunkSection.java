package com.xboxbedrock.minecraft.notsocubicchunks.storage;

import com.xboxbedrock.minecraft.notsocubicchunks.util.NibbleArray;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.PalettedContainer;

//This is actually just a subchunk, but oh well i'll just call it cube
public interface INotCubicChunkSection {

    int getSectionX();
    int getSectionZ();
    int getSectionY();

    short getBlockCount();

    CompoundTag getBlockStatesNBT();

    CompoundTag getBiomesNBT();

    NibbleArray getBlockLight();

    NibbleArray getSkyLight();

    void writeToNBT(CompoundTag tag);

}

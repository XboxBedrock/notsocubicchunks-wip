package com.xboxbedrock.minecraft.notsocubicchunks.storage;

import net.minecraft.nbt.CompoundTag;
import java.util.List;

public interface INotCubicChunk {

    String getWorldName();

    int getX();
    int getZ();

    //This is a cube coordinate
    //int getLayerBottomCubeHeightCC();

    //This is a cube coordinate
    //int getLayerTopCubeHeightCC();

    //Both the below methods are lies we make to vanilla minecraft
    int getMinSection();
    int getMaxSection();

    INotCubicChunkSection[] getSections();

    //void setLayerBottomCubeHeightCC(int layerBottomCubeHeightCC);
    //void setLayerTopCubeHeightCC(int layerTopCubeHeightCC);

    //Realistically this will just be nonexistant for a while, might have to create some heightmap computation code later but frankly i doubt how much it is worth for now
    CompoundTag getHeightMap();

    //These two methods will just return 0 for now because yes
    List<CompoundTag> getTileEntities();
    List<CompoundTag> getEntities();



}

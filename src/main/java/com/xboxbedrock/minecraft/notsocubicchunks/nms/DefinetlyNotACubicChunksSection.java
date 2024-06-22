package com.xboxbedrock.minecraft.notsocubicchunks.nms;

import com.xboxbedrock.minecraft.notsocubicchunks.storage.INotCubicChunkSection;
import com.xboxbedrock.minecraft.notsocubicchunks.util.NibbleArray;
import net.minecraft.nbt.CompoundTag;

public class DefinetlyNotACubicChunksSection implements INotCubicChunkSection {

    private int x;
    private int y;
    private int z;

    private short blockCount;

    //This is a palleted container, but that sounds like a minecraft issue, i'm just gonna save and load this and hope and pray
    private CompoundTag blockData;

    private CompoundTag biomeData;

    private NibbleArray blockLight;

    private NibbleArray skyLight;


    public DefinetlyNotACubicChunksSection(int x, int y, int z, CompoundTag blockData, CompoundTag biomeData, NibbleArray blockLight, NibbleArray skyLight, short blockCount) {


        this.blockData = blockData;
        this.biomeData = biomeData;
        this.blockLight = blockLight;
        this.skyLight = skyLight;

        this.x = x;
        this.y = y;
        this.z = z;

        this.blockCount = blockCount;
    }

    @Override
    public int getSectionX() {
        return x;
    }

    @Override
    public int getSectionZ() {
        return z;
    }

    @Override
    public int getSectionY() {
        return y;
    }

    @Override
    public short getBlockCount() {
        return blockCount;
    }

    @Override
    public CompoundTag getBlockStatesNBT() {
        return blockData;
    }

    @Override
    public CompoundTag getBiomesNBT() {
        return biomeData;
    }

    @Override
    public NibbleArray getBlockLight() {
        return blockLight;
    }

    @Override
    public NibbleArray getSkyLight() {
        return skyLight;
    }

    @Override
    public void writeToNBT(CompoundTag tag) {
        tag.put("BlockData", blockData);
        tag.put("BiomeData", biomeData);
        tag.putShort("BlockCount", this.blockCount);
        tag.putInt("Xcoord", this.x);
        tag.putInt("Ycoord", this.y);
        tag.putInt("Zcoord", this.z);
        tag.putByteArray("BlockLight", blockLight.getStoredBytes());
        tag.putByteArray("SkyLight", skyLight.getStoredBytes());
    }

    public static DefinetlyNotACubicChunksSection readFromNBT(CompoundTag tag) {
        CompoundTag nbtBlockData = (CompoundTag) tag.get("BlockData");
        CompoundTag nbtBiomeData = (CompoundTag) tag.get("BiomeData");
        short nbtBlockCount = tag.getShort("BlockCount");
        int nbtX = tag.getInt("Xcoord");
        int nbtY = tag.getInt("Ycoord");
        int nbtZ = tag.getInt("Zcoord");
        byte[] nbtBlockLight = tag.getByteArray("BlockLight");
        byte[] nbtSkyLight = tag.getByteArray("SkyLight");

        NibbleArray nibbleBlockLight = new NibbleArray(nbtBlockLight);
        NibbleArray nibbleSkyLight = new NibbleArray(nbtSkyLight);

        return new DefinetlyNotACubicChunksSection(nbtX, nbtY, nbtZ, nbtBlockData, nbtBiomeData, nibbleBlockLight, nibbleSkyLight, nbtBlockCount);
    }
}

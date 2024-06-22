package com.xboxbedrock.minecraft.notsocubicchunks.nms;

import com.mojang.serialization.Codec;
import com.xboxbedrock.minecraft.notsocubicchunks.storage.INotCubicChunk;
import com.xboxbedrock.minecraft.notsocubicchunks.storage.INotCubicChunkSection;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.PalettedContainer;
import net.minecraft.world.level.chunk.PalettedContainerRO;
import net.minecraft.world.level.lighting.LevelLightEngine;

import java.util.List;

public class NotACubicChunk implements INotCubicChunk {

    private LevelChunk handle;

    @Override
    public String getWorldName() {
        //Don't even ask me why they renamed the field to K
        return handle.getLevel().getMinecraftWorld().K.getLevelName();
    }

    @Override
    public int getX() {
        return handle.getPos().x;
    }

    @Override
    public int getZ() {
        return handle.getPos().z;
    }

    @Override
    public int getMinSection() {
        return handle.getMinSection();
    }

    @Override
    public int getMaxSection() {
        return handle.getMaxSection();
    }

    @Override
    public INotCubicChunkSection[] getSections() {
        INotCubicChunkSection[] sections = new INotCubicChunkSection[handle.getMaxSection()-handle.getMinSection()+1];

        LevelLightEngine light = handle.getLevel().getChunkSource().getLightEngine();

        //TODO: I need to figure out what the biome registry is
        //Registry<Biome> biomeRegistry = handle.getLevel().registryAccess().registryOrThrow(Registry.);

        //Weird spigot gunglegarbage

        //Codec<PalettedContainerRO<Holder<Biome>>> biomeCodec = PalettedContainer.codecRO(biomeRegistry.asHolderIdMap(), biomeRegistry.holderByNameCodec(), PalettedContainer.Strategy.SECTION_BIOMES, biomeRegistry.getHolderOrThrow(Biomes.PLAINS));
        return null;
    }

    @Override
    public CompoundTag getHeightMap() {
        return null;
    }

    @Override
    public List<CompoundTag> getTileEntities() {
        return List.of();
    }

    @Override
    public List<CompoundTag> getEntities() {
        return List.of();
    }
}

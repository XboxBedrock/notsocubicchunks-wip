package com.xboxbedrock.minecraft.notsocubicchunks.nms;

import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.progress.ChunkProgressListener;
import net.minecraft.world.RandomSequences;
import net.minecraft.world.level.CustomSpawner;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.storage.LevelStorageSource;
import net.minecraft.world.level.storage.PrimaryLevelData;
import org.bukkit.World;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.ChunkGenerator;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.Executor;

public class CustomWorldServer extends ServerLevel {
    public CustomWorldServer(MinecraftServer minecraftserver, Executor executor, LevelStorageSource.LevelStorageAccess convertable_conversionsession, PrimaryLevelData iworlddataserver, ResourceKey<Level> resourcekey, LevelStem worlddimension, ChunkProgressListener worldloadlistener, boolean flag, long i, List<CustomSpawner> list, boolean flag1, @Nullable RandomSequences randomsequences, World.Environment env, ChunkGenerator gen, BiomeProvider biomeProvider) {
        super(minecraftserver, executor, convertable_conversionsession, iworlddataserver, resourcekey, worlddimension, worldloadlistener, flag, i, list, flag1, randomsequences, env, gen, biomeProvider);
    }
}

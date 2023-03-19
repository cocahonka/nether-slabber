package org.cocahonka.nether_slabber_mod.util;
import net.minecraft.nbt.NbtCompound;

public interface IEntityDataSaver {
    NbtCompound getPersistentData();
}
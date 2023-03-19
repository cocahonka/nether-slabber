package org.cocahonka.nether_slabber_mod.util;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import org.cocahonka.nether_slabber_mod.command.FirstPosCommand;
import org.cocahonka.nether_slabber_mod.command.SecondPosCommand;
import org.cocahonka.nether_slabber_mod.command.SlabberCommand;
import org.cocahonka.nether_slabber_mod.event.ModPlayerEventCopyFrom;

public class ModRegistries {
    public static void registerModStuffs() {
        registerCommands();
        registerEvents();
    }

    private static void registerCommands() {
        CommandRegistrationCallback.EVENT.register(FirstPosCommand::register);
        CommandRegistrationCallback.EVENT.register(SecondPosCommand::register);
        CommandRegistrationCallback.EVENT.register(SlabberCommand::register);
    }

    private static void registerEvents() {
        ServerPlayerEvents.COPY_FROM.register(new ModPlayerEventCopyFrom());
    }
}

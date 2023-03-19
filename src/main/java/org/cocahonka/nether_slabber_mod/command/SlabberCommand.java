package org.cocahonka.nether_slabber_mod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import org.cocahonka.nether_slabber_mod.util.IEntityDataSaver;

public class SlabberCommand {
    public static void register(CommandDispatcher<ServerCommandSource> serverCommandSourceCommandDispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        serverCommandSourceCommandDispatcher.register(CommandManager.literal("slabber").executes(SlabberCommand::run));
    }

    public static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
//        IEntityDataSaver player = (IEntityDataSaver)context.getSource().getPlayer();
//        BlockPos playerPos = context.getSource().getPlayer().getBlockPos();
//        String pos = "(" + playerPos.getX() + ", " + playerPos.getY() + ", " + playerPos.getZ() + ")";
//
//        player.getPersistentData().putIntArray("corner1",
//                new int[] {playerPos.getX(), playerPos.getY(), playerPos.getZ() });
//
//        context.getSource().getPlayer().sendMessage(Text.literal("corner1 -> " + pos).fillStyle(Style.EMPTY.withColor(Formatting.DARK_PURPLE)));
        return 1;
    }
}

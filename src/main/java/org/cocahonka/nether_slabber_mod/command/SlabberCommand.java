package org.cocahonka.nether_slabber_mod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
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
        IEntityDataSaver player = (IEntityDataSaver)context.getSource().getPlayer();
        final ServerWorld world = context.getSource().getWorld();
        final BlockState slab = Blocks.COBBLESTONE_SLAB.getDefaultState();
        if (!world.isClient) {

            int[] corner1 = player.getPersistentData().getIntArray("corner1");
            int[] corner2 = player.getPersistentData().getIntArray("corner2");

            if (corner1.length != 0 && corner2.length != 0) {
                int x1 = corner1[0];
                int y1 = corner1[1];
                int z1 = corner1[2];

                int x2 = corner2[0];
                int y2 = corner2[1];
                int z2 = corner2[2];

                if (x1 > x2) {
                    int t = x1;
                    x1 = x2;
                    x2 = t;
                }
                if (y1 > y2) {
                    int t = y1;
                    y1 = y2;
                    y2 = t;
                }
                if (z1 > z2) {
                    int t = z1;
                    z1 = z2;
                    z2 = t;
                }

                for (int x = x1; x < x2 + 1; x++) {
                    for (int z = z1; z < z2 + 1; z++) {
                        for (int y = y1; y < y2 + 1; y++) {
                            final BlockState blockState = world.getBlockState(new BlockPos(x, y, z));
                            if (!blockState.isAir() && !blockState.getMaterial().isLiquid() && blockState.getMaterial().isSolid() && blockState.getBlock() != Blocks.COBBLESTONE_SLAB) {
                                final BlockState firstUpperblockState = world.getBlockState(new BlockPos(x, y + 1, z));
                                final BlockState secondUpperblockState = world.getBlockState(new BlockPos(x, y + 2, z));
                                if (firstUpperblockState.isAir() && secondUpperblockState.isAir()) {
                                    world.setBlockState(new BlockPos(x,y + 1,z), slab);
                                }
                            }
                        }
                    }

                }
                context.getSource().getPlayer().sendMessage(Text.literal("Slabber done!").fillStyle(Style.EMPTY.withColor(Formatting.GREEN)));
            } else {
                context.getSource().getPlayer().sendMessage(Text.literal("You haven't set all corners!").fillStyle(Style.EMPTY.withColor(Formatting.DARK_RED)));
            }
        }

        return 1;
    }
}

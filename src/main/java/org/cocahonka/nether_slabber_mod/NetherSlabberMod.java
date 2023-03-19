package org.cocahonka.nether_slabber_mod;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.cocahonka.nether_slabber_mod.item.ModItems;
import org.cocahonka.nether_slabber_mod.item.custom.HelloKittySelectorItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetherSlabberMod implements ModInitializer {
	public static final String MOD_ID = "nether_slabber_mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.register();
		AttackBlockCallback.EVENT.register(this::onLeftClickBlock);
	}

	private ActionResult onLeftClickBlock(PlayerEntity playerEntity, World world, Hand hand, BlockPos blockPos, Direction direction) {
		final boolean f1 = !world.isClient();
		final boolean f2 = hand == Hand.MAIN_HAND;
		final Item f3 = playerEntity.getActiveItem().getItem();
		final boolean f4 = f3 instanceof HelloKittySelectorItem;
		if(f1 && f2 && f4){
			playerEntity.sendMessage(Text.literal("Second pos: " + blockPos.toShortString())
					.fillStyle(Style.EMPTY.withColor(Formatting.DARK_PURPLE)));
		}
		return ActionResult.PASS;
	}
}



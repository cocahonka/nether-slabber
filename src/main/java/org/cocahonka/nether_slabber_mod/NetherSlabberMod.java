package org.cocahonka.nether_slabber_mod;

import net.fabricmc.api.ModInitializer;
import org.cocahonka.nether_slabber_mod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetherSlabberMod implements ModInitializer {
	public static final String MOD_ID = "nether_slabber_mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.register();
	}
}

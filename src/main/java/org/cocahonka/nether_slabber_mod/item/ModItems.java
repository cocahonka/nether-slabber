package org.cocahonka.nether_slabber_mod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.cocahonka.nether_slabber_mod.NetherSlabberMod;

public class ModItems {

    public static final Item HELLO_KITTY_SELECTOR = registerItem("hello_kitty_selector",
            new Item(new FabricItemSettings().group(ItemGroup.TOOLS)));

    private static Item registerItem(String id, Item item){
        return Registry.register(Registry.ITEM, new Identifier(NetherSlabberMod.MOD_ID, id), item);
    }
    public static void register() {
        NetherSlabberMod.LOGGER.debug("Registering items for: " + NetherSlabberMod.MOD_ID);
    }
}

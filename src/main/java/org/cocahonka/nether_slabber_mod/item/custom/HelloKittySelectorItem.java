package org.cocahonka.nether_slabber_mod.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;

public class HelloKittySelectorItem extends Item {
    public HelloKittySelectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient() && context.getHand() == Hand.MAIN_HAND) {
            context.getPlayer().sendMessage(Text.literal("First pos: " + context.getBlockPos().toShortString())
                    .fillStyle(Style.EMPTY.withColor(Formatting.AQUA)));
        }
        return super.useOnBlock(context);
    }
}

package borg.locutus.totallynotmodded;

import borg.locutus.totallynotmodded.TotallyNotModdedMod;
import borg.locutus.totallynotmodded.block.BlockInitializer;
import borg.locutus.totallynotmodded.item.ItemInitializer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.CreativeModeTabRegistry;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TotallyNotModdedMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabCreator {
    @SubscribeEvent
    public static void buildContents(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(TotallyNotModdedMod.MODID, "tnm_items"), builder ->
                // Set name of tab to display
                builder.title(Component.translatable("item." + TotallyNotModdedMod.MODID + ".tnm_items"))
                        // Set icon of creative tab
                        .icon(() -> new ItemStack(ItemInitializer.AQUAMARINE_ITEM.get()))
                        // Add default items to tab
                        .displayItems((params, output) -> {
                            output.accept(ItemInitializer.AQUAMARINE_ITEM.get());
                            output.accept(new ItemStack(BlockInitializer.AQUAMARINE_ORE.get()).copyWithCount(1));
                        })
        );
    }

    /*@SubscribeEvent
    public static void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == CreativeModeTabRegistry.getTab(new ResourceLocation("tnm_items"))) {
            event.accept(ItemInitializer.AQUAMARINE_ITEM);
            event.accept(BlockInitializer.AQUAMARINE_ORE);
        }
    }*/
}

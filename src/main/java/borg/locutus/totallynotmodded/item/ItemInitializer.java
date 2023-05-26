package borg.locutus.totallynotmodded.item;

import borg.locutus.totallynotmodded.TotallyNotModdedMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ItemInitializer {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TotallyNotModdedMod.MODID);

    public static final RegistryObject<Item> AQUAMARINE_ITEM = ITEMS.register("aquamarine",
            () -> new Item(new Item.Properties()));
}

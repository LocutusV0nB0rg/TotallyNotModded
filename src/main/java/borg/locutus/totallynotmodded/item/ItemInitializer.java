package borg.locutus.totallynotmodded.item;

import borg.locutus.totallynotmodded.TotallyNotModdedMod;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MinecartItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ItemInitializer {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TotallyNotModdedMod.MODID);

    public static final RegistryObject<Item> AQUAMARINE_ITEM = ITEMS.register("aquamarine",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FASTCART_ITEM = ITEMS.register("fastcart",
            () -> new FastcartItem(AbstractMinecart.Type.RIDEABLE, (new Item.Properties()).stacksTo(1)));

}

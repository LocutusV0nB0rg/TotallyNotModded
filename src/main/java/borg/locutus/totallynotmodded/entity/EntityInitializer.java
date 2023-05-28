package borg.locutus.totallynotmodded.entity;

import borg.locutus.totallynotmodded.TotallyNotModdedMod;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInitializer {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TotallyNotModdedMod.MODID);

    public static final EntityType<? extends AbstractMinecart> FASTCART_ENTITY_TYPE =
            EntityType.Builder.<Fastcart>of(Fastcart::new, MobCategory.MISC).sized(0.98F, 0.7F).clientTrackingRange(8).build("fastcart");

}

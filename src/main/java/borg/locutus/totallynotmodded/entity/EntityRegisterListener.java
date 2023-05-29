package borg.locutus.totallynotmodded.entity;

import borg.locutus.totallynotmodded.TotallyNotModdedMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = TotallyNotModdedMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityRegisterListener {
    @SubscribeEvent
    public static void register(RegisterEvent event) {
        if (event.getRegistryKey() == ForgeRegistries.Keys.ENTITY_TYPES) {
            System.out.println("Hello from EntityRegisterListener.register");
            event.register(ForgeRegistries.Keys.ENTITY_TYPES,
                    helper -> helper.register(new ResourceLocation(TotallyNotModdedMod.MODID, "fastcart"), buildFastcartEntityType())
            );
            ModEntities.FASTCART = RegistryObject.create(new ResourceLocation(TotallyNotModdedMod.MODID, "fastcart"), ForgeRegistries.ENTITY_TYPES);
            System.out.println("Hello from end of EntityRegisterListener.register");
        }
    }


    private static EntityType<? extends AbstractMinecart> buildFastcartEntityType() {
        return EntityType.Builder.<Fastcart>of(Fastcart::new, MobCategory.MISC)
                .sized(0.98F, 0.7F)
                .clientTrackingRange(8)
                .build("fastcart");
    }
}

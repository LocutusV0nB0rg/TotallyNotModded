package borg.locutus.totallynotmodded;

import borg.locutus.totallynotmodded.entity.Fastcart;
import borg.locutus.totallynotmodded.entity.FastcartRenderer;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;


@Mod.EventBusSubscriber(modid = TotallyNotModdedMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityRendererRegisterListener {
    public static EntityType<? extends AbstractMinecart> FASTCART_ENTITY_TYPE;

    @SubscribeEvent
    public static void addEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(FASTCART_ENTITY_TYPE, (p_174070_) -> new FastcartRenderer<>(p_174070_, ModelLayers.MINECART));
    }


    @SubscribeEvent
    public static void register(RegisterEvent event) {
        FASTCART_ENTITY_TYPE =
                EntityType.Builder.<Fastcart>of(Fastcart::new, MobCategory.MISC).sized(0.98F, 0.7F).clientTrackingRange(8).build("fastcart");

        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> helper.register(
                "fastcart",
                FASTCART_ENTITY_TYPE));
    }


}

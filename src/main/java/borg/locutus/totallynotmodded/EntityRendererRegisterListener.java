package borg.locutus.totallynotmodded;

import borg.locutus.totallynotmodded.entity.EntityInitializer;
import borg.locutus.totallynotmodded.entity.Fastcart;
import borg.locutus.totallynotmodded.entity.FastcartRenderer;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import static borg.locutus.totallynotmodded.entity.EntityInitializer.FASTCART_ENTITY_TYPE;

@Mod.EventBusSubscriber(modid = TotallyNotModdedMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityRendererRegisterListener {

    @SubscribeEvent
    public static void addEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(FASTCART_ENTITY_TYPE, (p_174070_) -> new FastcartRenderer<>(p_174070_, ModelLayers.MINECART));
    }


    @SubscribeEvent
    public void register(RegisterEvent event) {
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> helper.register(
                "fastcart",
                FASTCART_ENTITY_TYPE));
    }


}

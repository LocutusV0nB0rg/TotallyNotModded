package borg.locutus.totallynotmodded.client;

import borg.locutus.totallynotmodded.TotallyNotModdedMod;
import borg.locutus.totallynotmodded.entity.FastcartRenderer;
import borg.locutus.totallynotmodded.entity.ModEntities;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = TotallyNotModdedMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EntityRendererRegisterListener {
    @SubscribeEvent
    public static void addEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.FASTCART.get(), (p_174070_) -> new FastcartRenderer<>(p_174070_, ModelLayers.MINECART));
    }
}

package borg.locutus.totallynotmodded;

import borg.locutus.totallynotmodded.entity.FastcartRenderer;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TotallyNotModdedMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityRendererRegisterListener {
    @SubscribeEvent
    public static void addEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityType.MINECART, (p_174070_) -> new FastcartRenderer<>(p_174070_, ModelLayers.MINECART));
    }
}

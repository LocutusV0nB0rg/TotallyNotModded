package borg.locutus.totallynotmodded;

import borg.locutus.totallynotmodded.block.BlockInitializer;
import borg.locutus.totallynotmodded.entity.FastcartEntityTypeProvider;
import borg.locutus.totallynotmodded.entity.FastcartRenderer;
import borg.locutus.totallynotmodded.item.ItemInitializer;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.MinecartRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TotallyNotModdedMod.MODID)
public class TotallyNotModdedMod
{
    public static final String MODID = "totallynotmodded";

    public TotallyNotModdedMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInitializer.ITEMS.register(modEventBus);
        BlockInitializer.BLOCKS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(CreativeTabCreator.class);

        registerFastcartRenderer();
    }

    private void registerFastcartRenderer() {
        EntityRenderers.register(EntityType.MINECART, (p_174070_) -> new FastcartRenderer<>(p_174070_, ModelLayers.MINECART));
    }
}

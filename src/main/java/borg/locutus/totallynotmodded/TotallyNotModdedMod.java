package borg.locutus.totallynotmodded;

import borg.locutus.totallynotmodded.block.BlockInitializer;
import borg.locutus.totallynotmodded.entity.EntityInitializer;
import borg.locutus.totallynotmodded.item.ItemInitializer;
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
        EntityInitializer.ENTITY_TYPES.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(CreativeTabCreator.class);
        MinecraftForge.EVENT_BUS.register(EntityRendererRegisterListener.class);

    }
}

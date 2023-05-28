package borg.locutus.totallynotmodded.entity;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.Minecart;

public class FastcartEntityTypeProvider {

    //This seems to be the problem.
    //The write in the register takes place too later after the registries are already locked.
    //Might have to properly setup the Mixins to circumvent this.
    public static final EntityType<Fastcart> FASTCART = register("fastcart", EntityType.Builder.<Fastcart>of(Fastcart::new, MobCategory.MISC).sized(0.98F, 0.7F).clientTrackingRange(8));

    private static <T extends Entity> EntityType<T> register(String p_20635_, EntityType.Builder<T> p_20636_) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, p_20635_, p_20636_.build(p_20635_));
    }
}

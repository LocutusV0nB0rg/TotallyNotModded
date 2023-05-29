package borg.locutus.totallynotmodded.entity;


import borg.locutus.totallynotmodded.item.ItemInitializer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class Fastcart extends AbstractMinecart {
    public Fastcart(EntityType<?> p_38470_, Level p_38471_) {
        super(p_38470_, p_38471_);
    }
    public Fastcart(Level p_38473_, double p_38474_, double p_38475_, double p_38476_) {
        super(ModEntities.FASTCART.get(), p_38473_, p_38474_, p_38475_, p_38476_);
    }

    public @NotNull InteractionResult interact(@NotNull Player player, @NotNull InteractionHand interactionHand) {
        InteractionResult ret = super.interact(player, interactionHand);
        if (ret.consumesAction()) return ret;
        if (player.isSecondaryUseActive()) {
            return InteractionResult.PASS;
        } else if (this.isVehicle()) {
            return InteractionResult.PASS;
        } else if (!this.level.isClientSide) {
            return player.startRiding(this) ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            return InteractionResult.SUCCESS;
        }
    }

    protected @NotNull Item getDropItem() {
        return ItemInitializer.FASTCART_ITEM.get();
    }

    public void activateMinecart(int p_38478_, int p_38479_, int p_38480_, boolean p_38481_) {
        if (p_38481_) {
            if (this.isVehicle()) {
                this.ejectPassengers();
            }

            if (this.getHurtTime() == 0) {
                this.setHurtDir(-this.getHurtDir());
                this.setHurtTime(10);
                this.setDamage(50.0F);
                this.markHurt();
            }
        }

    }

    @Override
    public Type getMinecartType() {
        return null;
    }


    @Override
    public ItemStack getPickResult() {
        return new ItemStack(ItemInitializer.FASTCART_ITEM.get());
    }

    @Override
    protected double getMaxSpeed() {
        return 2f;
    }

    @Override
    protected float getBlockSpeedFactor() {
        return 2f;
    }

    @Override
    public float getMaxCartSpeedOnRail() {
        return 2f;
    }

    @Override
    public float getCurrentCartSpeedCapOnRail() {
        return 2f;
    }

    @Override
    public float getMaxSpeedAirLateral() {
        return 2f;
    }

    @Override
    public float getMaxSpeedAirVertical() {
        return 2f;
    }
}

package net.hakivin.hakismob.entity.projectile;


import net.hakivin.hakismob.entity.HakisMobEntities;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.NetworkHooks;

public class SmallIceShard extends IceShard {
    public SmallIceShard(EntityType<? extends SmallIceShard> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public SmallIceShard(Level pLevel, LivingEntity pShooter, double pOffsetX, double pOffsetY, double pOffsetZ) {
        super(HakisMobEntities.SMALL_ICE_SHARD.get(), pShooter, pOffsetX, pOffsetY, pOffsetZ, pLevel);
    }

    public SmallIceShard(Level pLevel, double pX, double pY, double pZ, double pOffsetX, double pOffsetY, double pOffsetZ) {
        super(HakisMobEntities.SMALL_ICE_SHARD.get(), pX, pY, pZ, pOffsetX, pOffsetY, pOffsetZ, pLevel);
    }

    /**
     * Called when the arrow hits an entity
     */
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();
        if (entity instanceof LivingEntity) {
            entity.hurt(this.damageSources().mobProjectile(this, (LivingEntity) this.getOwner()), 1.0F);
            if (entity instanceof Player player && !((Player) entity).isBlocking()) {
                player.disableShield(true);
                player.setSpeed(0.1F);
                player.setTicksFrozen(140);
            }
        }
    }

    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        if (!this.level().isClientSide) {
            this.discard();
        }
    }

    /**
     * Called when this EntityIceShard hits a block or entity.
     */
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level().isClientSide) {
            this.discard();
        }

    }

    /**
     * Returns {@code true} if other Entities should be prevented from moving through this Entity.
     */
    public boolean isPickable() {
        return false;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean hurt(DamageSource pSource, float pAmount) {
        return false;
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}

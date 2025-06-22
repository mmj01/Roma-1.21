package Roma.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import cpw.mods.util.Lazy;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;


import java.util.List;

public class ReachItem extends SwordItem {


    public static final ResourceLocation ATTACK_SPEED_UUID = ResourceLocation.fromNamespaceAndPath("roma", "attack_speed_uuid");
    public static final ResourceLocation ATTACK_DAMAGE_UUID = ResourceLocation.fromNamespaceAndPath("roma", "attack_damage_uuid");
    public static final ResourceLocation REACH_MOD = ResourceLocation.fromNamespaceAndPath("roma", "reach_mod"); //A randomly generated version 4 UUID
    public static final ResourceLocation KNOCKBACK_MOD = ResourceLocation.fromNamespaceAndPath("roma", "knockback_mod"); //Another randomly generated version 4 UUID


    public double reach;
    public double knockBack;
    public final int damage;
    public final int attackSpd;

    public Lazy<? extends Multimap<Attribute, AttributeModifier>> ATTRIBUTE_LAZY_MAP = Lazy.of(() -> {
        Multimap<Attribute, AttributeModifier> map;

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();


        builder.put(CustomAttribute.ATTACK_REACH.get(), new AttributeModifier(REACH_MOD, reach, AttributeModifier.Operation.ADD_VALUE));
        builder.put(CustomAttribute.ATTACK_KNOCKBACK.get(), new AttributeModifier(KNOCKBACK_MOD,  knockBack, AttributeModifier.Operation.ADD_VALUE));

        map = builder.build();
        return map;
    });

    public ReachItem(Tier tier, int damage, int attackSpd, double reach, double knockBack, Properties properties) {
        super(tier, properties);
        this.reach = reach;
        this.knockBack = knockBack;
        this.damage = (int) ((float)damage + tier.getAttackDamageBonus());
        this.attackSpd = attackSpd;
    }


    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers(ItemStack stack) {
        ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();

        // Apply base attack damage and speed if you want
        builder.add(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_UUID, damage, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
        builder.add(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_UUID, attackSpd, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);

        // ✅ Apply your custom reach value to ENTITY_INTERACTION_RANGE
        builder.add(Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(REACH_MOD, reach, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);

        // Optionally, apply knockback
        builder.add(Attributes.ATTACK_KNOCKBACK, new AttributeModifier(KNOCKBACK_MOD, knockBack, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);

        return builder.build();
    }






    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        if (entity.level().isClientSide) return super.onEntitySwing(stack, entity); // Server-side only

        // Use Minecraft's built-in ENTITY_INTERACTION_RANGE attribute
        double reach = entity.getAttributeValue(Attributes.ENTITY_INTERACTION_RANGE);
        double reachSqr = reach * reach;

        Vec3 eyePos = entity.getEyePosition(); // 1.21
        Vec3 lookVec = entity.getLookAngle();
        Vec3 targetVec = eyePos.add(lookVec.scale(reach));

        AABB searchBox = entity.getBoundingBox().expandTowards(lookVec.scale(reach)).inflate(1.0D);

        EntityHitResult result = ProjectileUtil.getEntityHitResult(
                entity.level(), entity, eyePos, targetVec, searchBox,
                e -> e instanceof LivingEntity && !e.isSpectator() && e.isPickable()
        );

        if (result != null && result.getEntity() instanceof LivingEntity target) {
            double distSqr = entity.distanceToSqr(target);
            if (distSqr <= reachSqr) {
                if (entity instanceof Player player) {
                    target.hurt(entity.damageSources().playerAttack(player),
                            (float) entity.getAttributeValue(Attributes.ATTACK_DAMAGE));
                } else {
                    target.hurt(entity.damageSources().mobAttack(entity),
                            (float) entity.getAttributeValue(Attributes.ATTACK_DAMAGE));
                }
            }
        }

        return super.onEntitySwing(stack, entity);
    }

}
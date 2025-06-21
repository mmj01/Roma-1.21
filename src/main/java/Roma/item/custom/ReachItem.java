package Roma.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import cpw.mods.util.Lazy;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
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
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import org.checkerframework.checker.units.qual.C;
import org.joml.Vector3d;
import java.util.UUID;

public class ReachItem extends SwordItem {


    public static final ResourceLocation ATTACK_SPEED_UUID = ResourceLocation.fromNamespaceAndPath("roma", "attack_speed_uuid");
    public static final ResourceLocation ATTACK_DAMAGE_UUID = ResourceLocation.fromNamespaceAndPath("roma", "attack_damage_uuid");
    public static final ResourceLocation REACH_MOD = ResourceLocation.fromNamespaceAndPath("roma", "reach_mod"); //A randomly generated version 4 UUID
    public static final ResourceLocation KNOCKBACK_MOD = ResourceLocation.fromNamespaceAndPath("roma", "knockback_mod"); //Another randomly generated version 4 UUID


    public static double reach = 0;
    public static double knockBack= 0;
    public static final int damage=0;
    public static final int attackSpd=0;

    public static Lazy<? extends Multimap<Attribute, AttributeModifier>> ATTRIBUTE_LAZY_MAP = Lazy.of(() -> {
        Multimap<Attribute, AttributeModifier> map;

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();


        builder.put(CustomAttribute.ATTACK_REACH.get(), new AttributeModifier(REACH_MOD, reach, AttributeModifier.Operation.ADD_VALUE));
        builder.put(CustomAttribute.ATTACK_KNOCKBACK.get(), new AttributeModifier(KNOCKBACK_MOD,  knockBack, AttributeModifier.Operation.ADD_VALUE));

        map = builder.build();
        return map;
    });

    public ReachItem(Tier pTier, int dmg, float atkspd, double reach, double kb, Properties pProperties) {
        super(pTier, pProperties);
        ReachItem.reach =reach;
        knockBack=kb;
    }


    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers(ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = ATTRIBUTE_LAZY_MAP.get();

        ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
        for (Attribute attribute : map.keySet()) {
            // Get the ResourceKey for this Attribute
            ResourceKey<Attribute> key = BuiltInRegistries.ATTRIBUTE.getResourceKey(attribute)
                    .orElseThrow(() -> new IllegalStateException("Attribute not registered: " + attribute));

            // Get the Holder<Attribute> from the registry using the ResourceKey
            Holder<Attribute> holder = BuiltInRegistries.ATTRIBUTE.getHolderOrThrow(key);

            for (AttributeModifier modifier : map.get(attribute)) {
                builder.add(holder, modifier, EquipmentSlotGroup.MAINHAND);
            }
        }
        return builder.build();
    }




    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        // Only run on server side
        if (entity.level().isClientSide) return super.onEntitySwing(stack, entity);

        // Get the custom reach attribute Holder
        Attribute rawReachAttr = CustomAttribute.ATTACK_REACH.get();

        ResourceKey<Attribute> key = BuiltInRegistries.ATTRIBUTE.getResourceKey(rawReachAttr)
                .orElseThrow(() -> new IllegalStateException("Reach attribute not registered"));

        Holder<Attribute> reachHolder = BuiltInRegistries.ATTRIBUTE.getHolderOrThrow(key);

        // Get reach value from entity's attribute
        double reach = entity.getAttributeValue(reachHolder);
        double reachSqr = reach * reach;

        // Get eye position and look vector of attacker
        Vec3 eyePos = entity.getEyePosition();
        Vec3 lookVec = entity.getLookAngle();
        Vec3 targetVec = eyePos.add(lookVec.scale(reach));

        // Expand bounding box for searching entities in reach
        AABB searchBox = entity.getBoundingBox().expandTowards(lookVec.scale(reach)).inflate(1.0D);

        // Ray trace to find target entity in reach
        EntityHitResult result = ProjectileUtil.getEntityHitResult(
                entity.level(), entity, eyePos, targetVec, searchBox,
                e -> e instanceof LivingEntity && !e.isSpectator() && e.isPickable()
        );

        // If hit entity is valid and within reach distance, apply damage
        if (result != null && result.getEntity() instanceof LivingEntity target) {
            double distSqr = entity.distanceToSqr(target);
            if (distSqr <= reachSqr) {
                float damageAmount = (float) entity.getAttributeValue(Attributes.ATTACK_DAMAGE);
                if (entity instanceof Player player) {
                    target.hurt(entity.damageSources().playerAttack(player), damageAmount);
                } else {
                    target.hurt(entity.damageSources().mobAttack(entity), damageAmount);
                }
                // You can add particles/sounds here if you want
                return true; // Indicate we handled the swing with a hit
            }
        }

        // Default behavior if no hit or out of range
        return super.onEntitySwing(stack, entity);
    }

}
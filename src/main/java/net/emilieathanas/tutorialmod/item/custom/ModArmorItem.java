package net.emilieathanas.tutorialmod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.emilieathanas.tutorialmod.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;

import java.util.List;
import java.util.Map;

import static net.emilieathanas.tutorialmod.item.ModItems.PINK_GARNET;

public class ModArmorItem extends Item{
    public enum ArmorSet { PINK_GARNET }

    private static final Map<ArmorSet, List<StatusEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorSet, List<StatusEffectInstance>>())
                    .put(ArmorSet.PINK_GARNET,
                            List.of(new StatusEffectInstance(StatusEffects.HASTE, 400, 2, false, false),
                                    new StatusEffectInstance(StatusEffects.JUMP_BOOST, 400, 1, false, false))).build();

    public ModArmorItem(Settings settings) {
        super(settings);
    }

    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, EquipmentSlot slot) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                if(hasFullSuitOfArmorOn(player)) {
                    evaluateArmorEffects(player);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot);
    }

    /**
     * checks if player is wearing all the correct armor type
     * then applies effects
     * @param player this player
     */
    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorSet, List<StatusEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorSet mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapStatusEffects);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, List<StatusEffectInstance> mapStatusEffect) {
        boolean hasPlayerEffect = mapStatusEffect.stream().allMatch(statusEffectInstance -> player.hasStatusEffect(statusEffectInstance.getEffectType()));

        if(!hasPlayerEffect) {
            for (StatusEffectInstance instance : mapStatusEffect) {
                player.addStatusEffect(new StatusEffectInstance(instance.getEffectType(),
                        instance.getDuration(), instance.getAmplifier(), instance.isAmbient(), instance.shouldShowParticles()));
            }
        }
    }

    /**
     * determines if player has full set of armor on
     * getEquippedStack returns the itemstack of the item the player is wearing in that slot
     * @param player
     * @return
     */
    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);
        ItemStack helmet = player.getEquippedStack(EquipmentSlot.HEAD);
        ItemStack chestplate = player.getEquippedStack(EquipmentSlot.CHEST);
        ItemStack leggings = player.getEquippedStack(EquipmentSlot.LEGS);

        return !helmet.isEmpty() && !chestplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }


    /**
     * checks if all the equipped armor slots are pink garnet armor items
     * @param material material must be pink garnet
     * @param player player to check
     * @return true if all armor items are of pink garnet
     */
    private boolean hasCorrectArmorOn(ArmorSet material, PlayerEntity player) {
        if(material == null){
            return false;
        }

        boolean correctBoots = player.getEquippedStack(EquipmentSlot.FEET).isOf(ModItems.PINK_GARNET_BOOTS);
        boolean correctChestplate = player.getEquippedStack(EquipmentSlot.CHEST).isOf(ModItems.PINK_GARNET_CHESTPLATE);
        boolean correctLeggings = player.getEquippedStack(EquipmentSlot.LEGS).isOf(ModItems.PINK_GARNET_LEGGINGS);
        boolean correctHelmet = player.getEquippedStack(EquipmentSlot.HEAD).isOf(ModItems.PINK_GARNET_HELMET);

        return correctBoots && correctChestplate && correctLeggings && correctHelmet;
    }
}
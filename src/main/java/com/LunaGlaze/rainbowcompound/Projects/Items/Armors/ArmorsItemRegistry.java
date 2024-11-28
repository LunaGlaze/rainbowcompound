package com.LunaGlaze.rainbowcompound.Projects.Items.Armors;

import com.LunaGlaze.rainbowcompound.Core.ArmorMaterials.CRCArmorItem;
import com.LunaGlaze.rainbowcompound.Core.ArmorMaterials.CRCArmorMaterials;
import com.LunaGlaze.rainbowcompound.Core.Registries.BaseRegistry;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ArmorsItemRegistry extends BaseRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LunaUtils.MOD_ID);
    public static final RegistryObject<Item> obsidianitehelmet = ITEMS.register("obsidianite_helmet", () ->
            new CRCArmorItem(CRCArmorMaterials.Obsidianite, Type.HELMET, (new Item.Properties().fireResistant())));
    public static final RegistryObject<Item> obsidianitechestplate = ITEMS.register("obsidianite_chestplate", () ->
            new CRCArmorItem(CRCArmorMaterials.Obsidianite, Type.CHESTPLATE, (new Item.Properties().fireResistant())));
    public static final RegistryObject<Item> obsidianiteleggings = ITEMS.register("obsidianite_leggings", () ->
            new CRCArmorItem(CRCArmorMaterials.Obsidianite, Type.LEGGINGS, (new Item.Properties().fireResistant())));
    public static final RegistryObject<Item> obsidianiteboots = ITEMS.register("obsidianite_boots", () ->
            new CRCArmorItem(CRCArmorMaterials.Obsidianite, Type.BOOTS, (new Item.Properties().fireResistant())));
    public static final RegistryObject<Item> rainbowhelmet = ITEMS.register("rainbow_helmet", () ->
            new CRCArmorItem(CRCArmorMaterials.RAINBOW, Type.HELMET, (new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON))));
    public static final RegistryObject<Item> rainbowchestplate = ITEMS.register("rainbow_chestplate", () ->
            new CRCArmorItem(CRCArmorMaterials.RAINBOW, Type.CHESTPLATE, (new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON))));
    public static final RegistryObject<Item> rainbowleggings = ITEMS.register("rainbow_leggings", () ->
            new CRCArmorItem(CRCArmorMaterials.RAINBOW, Type.LEGGINGS, (new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON))));
    public static final RegistryObject<Item> rainbowboots = ITEMS.register("rainbow_boots", () ->
            new CRCArmorItem(CRCArmorMaterials.RAINBOW, Type.BOOTS, (new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON))));

}

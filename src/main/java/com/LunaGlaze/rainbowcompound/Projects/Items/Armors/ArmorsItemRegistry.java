package com.LunaGlaze.rainbowcompound.Projects.Items.Armors;

import com.LunaGlaze.rainbowcompound.Core.ArmorMaterials.CRCArmorItem;
import com.LunaGlaze.rainbowcompound.Core.ArmorMaterials.CRCArmorMaterials;
import com.LunaGlaze.rainbowcompound.Core.Registries.BaseRegistry;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ArmorsItemRegistry extends BaseRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, LunaUtils.MOD_ID);
    public static final DeferredHolder<Item, Item> obsidianitehelmet = ITEMS.register("obsidianite_helmet", () ->
            new CRCArmorItem(CRCArmorMaterials.Obsidianite.value(), Type.HELMET, (new Item.Properties().fireResistant().durability(Type.HELMET.getDurability(38)))));
    public static final DeferredHolder<Item, Item> obsidianitechestplate = ITEMS.register("obsidianite_chestplate", () ->
            new CRCArmorItem(CRCArmorMaterials.Obsidianite.value(), Type.CHESTPLATE, (new Item.Properties().fireResistant().durability(Type.HELMET.getDurability(38)))));
    public static final DeferredHolder<Item, Item> obsidianiteleggings = ITEMS.register("obsidianite_leggings", () ->
            new CRCArmorItem(CRCArmorMaterials.Obsidianite.value(), Type.LEGGINGS, (new Item.Properties().fireResistant().durability(Type.HELMET.getDurability(38)))));
    public static final DeferredHolder<Item, Item> obsidianiteboots = ITEMS.register("obsidianite_boots", () ->
            new CRCArmorItem(CRCArmorMaterials.Obsidianite.value(), Type.BOOTS, (new Item.Properties().fireResistant().durability(Type.HELMET.getDurability(38)))));
    public static final DeferredHolder<Item, Item> rainbowhelmet = ITEMS.register("rainbow_helmet", () ->
            new CRCArmorItem(CRCArmorMaterials.Rainbow.value(), Type.HELMET, (new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON).durability(Type.HELMET.getDurability(48)))));
    public static final DeferredHolder<Item, Item> rainbowchestplate = ITEMS.register("rainbow_chestplate", () ->
            new CRCArmorItem(CRCArmorMaterials.Rainbow.value(), Type.CHESTPLATE, (new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON).durability(Type.HELMET.getDurability(48)))));
    public static final DeferredHolder<Item, Item> rainbowleggings = ITEMS.register("rainbow_leggings", () ->
            new CRCArmorItem(CRCArmorMaterials.Rainbow.value(), Type.LEGGINGS, (new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON).durability(Type.HELMET.getDurability(48)))));
    public static final DeferredHolder<Item, Item> rainbowboots = ITEMS.register("rainbow_boots", () ->
            new CRCArmorItem(CRCArmorMaterials.Rainbow.value(), Type.BOOTS, (new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON).durability(Type.HELMET.getDurability(48)))));

}

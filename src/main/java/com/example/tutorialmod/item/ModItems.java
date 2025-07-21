package com.example.tutorialmod.item;

import com.example.tutorialmod.TemplateMod;
import com.example.tutorialmod.item.custom.Prospector;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems{
    // Register Items
    public static final Item ICE_ETHER = registerItems("ice_ether", new Item(new Item.Settings()));
    public static final Item RAW_ICE_ETHER = registerItems("raw_ice_ether", new Item(new Item.Settings()));
    public static final Item XX_SWORD = registerItems("xx_sword", new SwordItem(ToolMaterials.NETHERITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 100, -0.4F))));
    public static final Item CHEESE = registerItems("cheese", new Item(new Item.Settings().food(ModFoodComponents.CHEESE)));
    public static final Item STRAWBERRY = registerItems("strawberry", new Item(new Item.Settings().food(ModFoodComponents.STRAWBERRY)));
    public static final Item ANTHRACITE = registerItems("anthracite", new Item(new Item.Settings()));

    public static final Item PROSPECTOR = registerItems("prospector", new Prospector(new Item.Settings().maxDamage(127)));

    private static Item registerItems(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TemplateMod.MOD_ID, id), item);
    }


    //Add Items to ItemGroup
    private static void addItemToIG(FabricItemGroupEntries fabricItemGroupEntries){
        fabricItemGroupEntries.add(ICE_ETHER);
        fabricItemGroupEntries.add(RAW_ICE_ETHER);
        fabricItemGroupEntries.add(XX_SWORD);
        fabricItemGroupEntries.add(CHEESE);
        fabricItemGroupEntries.add(STRAWBERRY);
        fabricItemGroupEntries.add(ANTHRACITE);
        fabricItemGroupEntries.add(PROSPECTOR);
    }

    public static void registerModItems(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIG);
        TemplateMod.LOGGER.info("Register Items");
    }

}

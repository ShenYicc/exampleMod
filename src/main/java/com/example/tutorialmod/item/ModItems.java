package com.example.tutorialmod.item;

import com.example.tutorialmod.TemplateMod;
import com.example.tutorialmod.item.custom.Prospector;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems{
    // Register Items
    public static final Item ICE_ETHER = registerItems("ice_ether", new Item(new Item.Settings()));
    public static final Item RAW_ICE_ETHER = registerItems("raw_ice_ether", new Item(new Item.Settings()));
    public static final Item XX_SWORD = registerItems("xx_sword",
            new SwordItem(ToolMaterials.NETHERITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 100, -0.4f))));
    public static final Item CHEESE = registerItems("cheese", new Item(new Item.Settings().food(ModFoodComponents.CHEESE)));
    public static final Item STRAWBERRY = registerItems("strawberry", new Item(new Item.Settings().food(ModFoodComponents.STRAWBERRY)));
    public static final Item ANTHRACITE = registerItems("anthracite", new Item(new Item.Settings()));

    public static final Item PROSPECTOR = registerItems("prospector", new Prospector(new Item.Settings().maxDamage(127)));
    public static final Item PLATE = registerItems("plate", new Item(new Item.Settings()));

    public static final Item FIRE_ETHER = registerItems("fire_ether", new Item(new Item.Settings()));
    public static final Item FIRE_ETHER_SWORD = registerItems("fire_ether_sword", new SwordItem(ModToolMaterials.FIRE_ETHER,
            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.FIRE_ETHER, 3, -2.0f))));

    public static final Item FIRE_ETHER_PICKAXE = registerItems("fire_ether_pickaxe", new PickaxeItem(ModToolMaterials.FIRE_ETHER,
            new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.FIRE_ETHER, 2, -2.8f))));

    public static final Item FIRE_ETHER_AXE = registerItems("fire_ether_axe", new AxeItem(ModToolMaterials.FIRE_ETHER,
            new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.FIRE_ETHER, 6, -3.2f))));

    public static final Item FIRE_ETHER_SHOVEL = registerItems("fire_ether_shovel", new ShovelItem(ModToolMaterials.FIRE_ETHER,
            new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.FIRE_ETHER, 1, -3.0f))));

    public static final Item FIRE_ETHER_HOE = registerItems("fire_ether_hoe", new HoeItem(ModToolMaterials.FIRE_ETHER,
            new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.FIRE_ETHER, -3, -1.0f))));



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
        fabricItemGroupEntries.add(PLATE);
        fabricItemGroupEntries.add(FIRE_ETHER);
        fabricItemGroupEntries.add(FIRE_ETHER_SWORD);
        fabricItemGroupEntries.add(FIRE_ETHER_PICKAXE);
        fabricItemGroupEntries.add(FIRE_ETHER_AXE);
        fabricItemGroupEntries.add(FIRE_ETHER_SHOVEL);
        fabricItemGroupEntries.add(FIRE_ETHER_HOE);

    }

    public static void registerModItems(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIG);
        TemplateMod.LOGGER.info("Register Items");
    }

}

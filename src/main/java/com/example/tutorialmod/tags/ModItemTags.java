package com.example.tutorialmod.tags;

import com.example.tutorialmod.TemplateMod;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItemTags {

    private static RegistryKey<Item> of(String id){
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TemplateMod.MOD_ID, id));
    }
}

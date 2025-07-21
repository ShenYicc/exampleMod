package com.example.tutorialmod.item;

import com.example.tutorialmod.TemplateMod;
import com.example.tutorialmod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final RegistryKey<ItemGroup> TEMPLATE_GROUP = register("template_group");

    private static RegistryKey<ItemGroup> register(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(TemplateMod.MOD_ID, id));
    }

    public static void registerModItemGroups(){
        Registry.register(Registries.ITEM_GROUP, TEMPLATE_GROUP,
                ItemGroup.create(ItemGroup.Row.TOP, 7)
                        .displayName(Text.translatable("itemGroup.template_group"))
                        .icon(()->new ItemStack(ModItems.ICE_ETHER))
                        .entries((displayContext, entries) -> {
                            //Items
                            entries.add(ModItems.ICE_ETHER);
                            entries.add(ModItems.RAW_ICE_ETHER);
                            entries.add(ModItems.XX_SWORD);
                            entries.add(ModItems.CHEESE);
                            entries.add(ModItems.STRAWBERRY);
                            entries.add(ModItems.ANTHRACITE);
                            entries.add(ModItems.PROSPECTOR);

                            //Blocks
                            entries.add(ModBlocks.ICE_ETHER_BLOCK);
                            entries.add(ModBlocks.ICE_ETHER_ORE);
                            entries.add(ModBlocks.RAW_ICE_ETHER_BLOCK);
                        })
                        .build()
        );
        TemplateMod.LOGGER.info("Register ItemGroup");
    }
}

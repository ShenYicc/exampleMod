package com.example.tutorialmod.tags;

import com.example.tutorialmod.TemplateMod;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {
    public static final TagKey<Block> ORE_LIST = of("ore_list");

    private static TagKey<Block> of(String id){
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TemplateMod.MOD_ID, id));
    }

    public static void registerModBlockTags(){
        TemplateMod.LOGGER.info("Register mod block tags.");
    }
}

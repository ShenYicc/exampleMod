package com.example.tutorialmod.datagen;

import com.example.tutorialmod.TemplateMod;
import com.example.tutorialmod.block.ModBlocks;
import com.example.tutorialmod.item.ModItems;
import com.example.tutorialmod.tags.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> ICE_ETHER = List.of(ModItems.RAW_ICE_ETHER, Items.ICE);

    public ModRecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.ICE_ETHER,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ETHER_BLOCK);

        offerSmelting(recipeExporter, ICE_ETHER, RecipeCategory.MISC, ModItems.RAW_ICE_ETHER,
                0.6f, 200, "ice_ether");
        offerBlasting(recipeExporter, ICE_ETHER, RecipeCategory.MISC, ModItems.RAW_ICE_ETHER,
                0.8f, 100, "ice_ether");

        offerFoodCookingRecipe(recipeExporter, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new,
                600, ModItems.RAW_ICE_ETHER, ModItems.ICE_ETHER, 0.35f);
        offerFoodCookingRecipe(recipeExporter, "smoking", RecipeSerializer.SMOKING, SmokingRecipe::new,
                700, ModItems.RAW_ICE_ETHER, ModItems.ICE_ETHER, 0.25f);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SUGAR, 3)
                .pattern("###")
                .input('#', ModItemTags.SUGAR_TAG)
                .criterion("has_item", RecipeProvider.conditionsFromTag(ModItemTags.SUGAR_TAG))
                .offerTo(recipeExporter, Identifier.of(TemplateMod.MOD_ID, "sugar_tag_to_sugar"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ETHER_ORE)
                .input(ModItems.RAW_ICE_ETHER)
                .input(Items.STONE)
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.RAW_ICE_ETHER))
                .criterion("has_item", RecipeProvider.conditionsFromItem(Items.STONE))
                .offerTo(recipeExporter, Identifier.of(TemplateMod.MOD_ID, "ice_ether_ore"));
    }
}

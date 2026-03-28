package net.emilieathanas.tutorialmod.datagen;

import net.emilieathanas.tutorialmod.TutorialMod;
import net.emilieathanas.tutorialmod.block.ModBlocks;
import net.emilieathanas.tutorialmod.item.ModArmorMaterials;
import net.emilieathanas.tutorialmod.item.ModItems;
import net.emilieathanas.tutorialmod.trim.ModTrimPatterns;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                List<ItemConvertible> PINK_GARNRET_SMELTABLES = List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE, ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
                offerSmelting(PINK_GARNRET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 200, "pink_garnet");
                offerBlasting(PINK_GARNRET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 200, "pink_garnet");

                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_GARNET, RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_BLOCK);

                ShapedRecipeJsonBuilder.create(this.registries.getOrThrow(RegistryKeys.ITEM), RecipeCategory.MISC, ModBlocks.RAW_PINK_GARNET_BLOCK)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .input('R', ModItems.RAW_PINK_GARNET)
                        .criterion(hasItem(ModItems.RAW_PINK_GARNET), conditionsFromItem(ModItems.RAW_PINK_GARNET))
                        .offerTo(exporter);

                ShapelessRecipeJsonBuilder.create((this.registries.getOrThrow(RegistryKeys.ITEM)), RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 9)
                        .input(ModBlocks.RAW_PINK_GARNET_BLOCK)
                        .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
                        .offerTo(exporter);

                ShapelessRecipeJsonBuilder.create((this.registries.getOrThrow(RegistryKeys.ITEM)), RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 32)
                        .input(ModBlocks.MAGIC_BLOCK)
                        .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.MAGIC_BLOCK))
                        .offerTo(exporter, "raw_pink_garnet_from_magic_block");

                createDoorRecipe(ModBlocks.PINK_GARNET_DOOR, Ingredient.ofItem(ModBlocks.PINK_GARNET_BLOCK));

                Item bloomingmaroonSmithingTemplate = ModItems.BLOOMINGMAROON_ARMOR_TRIM_SMITHING_TEMPLATE;
                offerSmithingTrimRecipe(bloomingmaroonSmithingTemplate, ModTrimPatterns.BLOOMINGMAROON, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(bloomingmaroonSmithingTemplate.getTranslationKey().substring(17) + "_smithing_trim")));
                offerSmithingTemplateCopyingRecipe(ModItems.BLOOMINGMAROON_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.PINK_GARNET_BLOCK);

            }
        };
    }

    @Override
    public String getName() {
        return "Tutorial Mod Recipes";
    }
}

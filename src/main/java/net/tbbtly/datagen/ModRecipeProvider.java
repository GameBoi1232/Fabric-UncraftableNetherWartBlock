package net.tbbtly.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {

                shapeless(RecipeCategory.BREWING, Items.NETHER_WART, 9)
                        .requires(Items.NETHER_WART_BLOCK)
                        //.define('W', Items.NETHER_WART_BLOCK)
                        .unlockedBy(getHasName(Items.NETHER_WART), has(Items.NETHER_WART))
                        .unlockedBy(getHasName(Items.NETHER_WART_BLOCK), has(Items.NETHER_WART_BLOCK))
                        .save(output);
            }
        };

    }

    @Override
    public String getName() {
        return "Uncraftable Nether Wart Blocks Recipes";
    }
}

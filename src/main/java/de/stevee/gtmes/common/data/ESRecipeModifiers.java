package de.stevee.gtmes.common.data;

import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;
import de.stevee.gtmes.common.data.machines.ElementSorterMachine;
import org.jetbrains.annotations.NotNull;

public class ESRecipeModifiers {

    public static final RecipeModifier HEAT_MODIFIER = ESRecipeModifiers::heatModifier;

    public static @NotNull ModifierFunction heatModifier(@NotNull MetaMachine metaMachine, @NotNull GTRecipe gtRecipe) {
        double heat;
        if (metaMachine instanceof ElementSorterMachine machine) {
            heat = machine.getHeatK();
            return ModifierFunction.builder()
                    .eutModifier(ContentModifier.addition(8 * Math.pow(heat, heat / 2d)))
                    .build();
        }
        return ModifierFunction.IDENTITY;
    }

}

package de.stevee.gtmes.common.data.machines;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import net.minecraft.network.chat.Component;

import static com.gregtechceu.gtceu.api.pattern.util.RelativeDirection.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeModifiers.*;
import static de.stevee.gtmes.api.registry.registrate.ESRegistrate.REGISTRATE;
import static de.stevee.gtmes.common.data.ESRecipeModifiers.HEAT_MODIFIER;
import static de.stevee.gtmes.common.data.ESRecipeTypes.ELEMENT_SORTER_RECIPES;
import static net.minecraft.world.level.block.Blocks.CAULDRON;

public class ESMultiMachines {
    public static final MultiblockMachineDefinition ELEMENT_SORTER = REGISTRATE.multiblock("element_sorter", ElementSorterMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(ELEMENT_SORTER_RECIPES)
            .appearanceBlock(CASING_TUNGSTENSTEEL_ROBUST)
            .recipeModifiers(OC_NON_PERFECT, HEAT_MODIFIER)
            .langValue("Electro-Thermal Element Distribution Center")
            .tooltips(Component.literal("Element Sorter / EDC"))
            .pattern((definition -> FactoryBlockPattern.start(BACK, UP, LEFT)
                    .aisle("BBB", "BOB", "BOB", "BBB")
                    .aisle("BBB", "CGB", "OGB", "BBB")
                    .aisle("BBB", "OIB", "BIB", "BBB")
                    .aisle("BBB", " V ", " P ", "   ").setRepeatable(3, 9)
                    .where('B', Predicates.blocks(CASING_TUNGSTENSTEEL_ROBUST.get()).or(Predicates.autoAbilities(definition.getRecipeTypes())))
                    .where('C', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where(' ', Predicates.any())
                    .where('G', Predicates.blocks(CASING_TUNGSTENSTEEL_GEARBOX.get()))
                    .where('I', Predicates.blocks(CASING_EXTREME_ENGINE_INTAKE.get()))
                    .where('V', Predicates.blocks(CAULDRON))
                    .where('P', Predicates.blocks(CASING_TUNGSTENSTEEL_PIPE.get()))
                    .where('O', Predicates.blocks(CASING_TUNGSTENSTEEL_ROBUST).or())
                    .build()))
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_robust_tungstensteel"), GTCEu.id("block/multiblock/evaporation_plant"))
            .register();

    public static void init() {

    }
}

package de.stevee.gtmes.common.data;

import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.common.registry.GTRegistration;
import de.stevee.gtmes.api.registry.registrate.ESRegistrate;

import static com.gregtechceu.gtceu.common.data.GTCreativeModeTabs.MACHINE;

public class ESMachines {
    static {
        GTRegistration.REGISTRATE.creativeModeTab(() -> MACHINE);
        GTRegistries.MACHINES.unfreeze();
    }


    public static void init() {}

}

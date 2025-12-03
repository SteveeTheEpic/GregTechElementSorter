package de.stevee.gtmes.api.registry.registrate;

import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.common.registry.GTRegistration;
import de.stevee.gtmes.ElementSorter;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class ESRegistrate {
    public static final GTRegistrate REGISTRATE = GTRegistrate.create(ElementSorter.MOD_ID);

    static {
        REGISTRATE.defaultCreativeTab((ResourceKey<CreativeModeTab>) null);
    }
}

package net.dovtech.superweapons.blocks.systems;

import api.element.block.Blocks;
import org.schema.game.common.data.element.ElementInformation;

public class HeatReflector {

    public static ElementInformation blockInfo;

    public HeatReflector() {
        blockInfo.setFullName("Heat Reflector");
        blockInfo.setDescription("Reflects heat energy to the Neutronium Siphon. More active reflectors means more heat reflected, but too much heat can cause a meltdown. Connect this block to a ratio of ON and OFF Activation Modules to control how much heat is reflected back. The more modules that are ON than OFF, the more heat is reflected, and vice-versa.");
        blockInfo.setArmorValue(1);
        blockInfo.setMaxHitPointsE(1);
        blockInfo.setBuildIconNum(0);
        blockInfo.setCanActivate(true);
        blockInfo.setShoppable(true);
        blockInfo.setAnimated(false);
        blockInfo.setEnterable(false);
        blockInfo.setProducedInFactory(1);
        blockInfo.setDoor(false);
        blockInfo.systemBlock = true;
        blockInfo.controlledBy.add(StellarLifterController.blockInfo.id);
        blockInfo.controlling.add(Blocks.ACTIVATION_MODULE.getId());
    }
}

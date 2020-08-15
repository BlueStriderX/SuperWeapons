package net.dovtech.superweapons.blocks.systems;

import org.schema.game.common.data.element.ElementInformation;

public class NeutroniumSiphonController {

    public static ElementInformation blockInfo;

    public NeutroniumSiphonController() {
        blockInfo.setFullName("Neutronium Siphon Controller");
        blockInfo.setDescription("Controls a Neutronium Siphon System. Link to a Stellar Lifter Controller to manage the system.");
        blockInfo.setArmorValue(1);
        blockInfo.setMaxHitPointsE(1);
        blockInfo.setBuildIconNum(0);
        blockInfo.setCanActivate(false);
        blockInfo.setShoppable(true);
        blockInfo.setAnimated(false);
        blockInfo.setEnterable(false);
        blockInfo.setProducedInFactory(1);
        blockInfo.setDoor(false);
        blockInfo.supportCombinationController = true;
        blockInfo.systemBlock = true;
        blockInfo.controlledBy.add(StellarLifterController.blockInfo.getId());
        blockInfo.controlling.add(NeutroniumSiphonModule.blockInfo.getId());
    }
}
package net.dovtech.superweapons.blocks.systems;

import api.config.BlockConfig;
import org.schema.game.common.data.element.ElementInformation;

public class StellarLifterController {

    public static ElementInformation blockInfo = BlockConfig.newElement("Stellar Lifter Controller");

    public StellarLifterController() {
        blockInfo.setFullName("Stellar Lifter Controller");
        blockInfo.setDescription("Controls a Stellar Lifter system and manages the extraction of Neutronium Energy. Input extracted energy into a Matter Fabricator system to produce raw minerals.");
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
        blockInfo.controlling.add(NeutroniumSiphonModule.blockInfo.id);
        blockInfo.controlling.add(HeatReflector.blockInfo.id);
    }
}

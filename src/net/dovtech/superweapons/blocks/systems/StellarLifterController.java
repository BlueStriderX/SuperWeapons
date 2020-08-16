package net.dovtech.superweapons.blocks.systems;

import api.element.block.Blocks;
import org.schema.game.common.data.element.ElementInformation;

public class StellarLifterController {

    public static ElementInformation blockInfo;

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
        blockInfo.setIndividualSides(6);
        blockInfo.setTextureId(new short[] { 769, 768, 371, 377, 770, 770 });
        blockInfo.mainCombinationController = true;
        blockInfo.systemBlock = true;
        blockInfo.controlledBy.add(Blocks.SHIP_CORE.getId());
        blockInfo.controlling.add(GravityCompressorController.blockInfo.id);
        blockInfo.controlling.add(NeutroniumCapacitor.blockInfo.getId());
        blockInfo.controlling.add(HeatReflector.blockInfo.id);
        Blocks.SHIP_CORE.getInfo().controlling.add(blockInfo.getId());
    }
}

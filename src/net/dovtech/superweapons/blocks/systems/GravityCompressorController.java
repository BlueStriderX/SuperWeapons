package net.dovtech.superweapons.blocks.systems;

import org.schema.game.common.data.element.ElementInformation;

public class GravityCompressorController {

    public static ElementInformation blockInfo;

    public GravityCompressorController() {
        blockInfo.setFullName("Gravity Compressor Controller");
        blockInfo.setDescription("Controls a Gravity Compressor System. Link to a Stellar Lifter Controller to manage the system.");
        blockInfo.setArmorValue(1);
        blockInfo.setMaxHitPointsE(1);
        blockInfo.setBuildIconNum(0);
        blockInfo.setCanActivate(false);
        blockInfo.setShoppable(true);
        blockInfo.setAnimated(false);
        blockInfo.setEnterable(false);
        blockInfo.setProducedInFactory(1);
        blockInfo.setDoor(false);
        blockInfo.setIndividualSides(6);
        blockInfo.setTextureId(new short[] { 768, 771, 371, 377, 772, 772 });
        blockInfo.supportCombinationController = true;
        blockInfo.systemBlock = true;
        blockInfo.controlledBy.add(StellarLifterController.blockInfo.getId());
        blockInfo.controlling.add(GravityCompressorModule.blockInfo.getId());
    }
}
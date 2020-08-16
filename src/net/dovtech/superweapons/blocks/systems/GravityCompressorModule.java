package net.dovtech.superweapons.blocks.systems;

import org.schema.game.common.data.element.ElementInformation;

public class GravityCompressorModule {

    public static ElementInformation blockInfo;

    public GravityCompressorModule() {
        blockInfo.setFullName("Gravity Compressor Module");
        blockInfo.setDescription("Compresses gravity to pull nearby matter towards it.");
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
        blockInfo.setTextureId(new short[] { 775, 773, 775, 775, 774, 774 });
        blockInfo.systemBlock = true;
        blockInfo.controlledBy.add(GravityCompressorController.blockInfo.id);
    }
}

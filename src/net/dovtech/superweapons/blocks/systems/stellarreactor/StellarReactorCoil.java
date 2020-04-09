package net.dovtech.superweapons.blocks.systems.stellarreactor;

import org.schema.game.common.data.element.ElementInformation;

public class StellarReactorCoil {

    private ElementInformation blockInfo;

    public StellarReactorCoil() {
        blockInfo.setFullName("Stellar Reactor Coil");
        blockInfo.setDescription("Generates heat energy for the Stellar Reactor. The hotter these get, the more volatile they become.");
        blockInfo.setArmorValue(1);
        blockInfo.setMaxHitPointsE(1);
        blockInfo.setBuildIconNum(0);
        blockInfo.setCanActivate(true);
        blockInfo.setShoppable(true);
        blockInfo.setAnimated(true);
        blockInfo.setEnterable(false);
        blockInfo.setProducedInFactory(1);
        blockInfo.setDoor(false);
    }

    public ElementInformation getBlockInfo() {
        return blockInfo;
    }

}

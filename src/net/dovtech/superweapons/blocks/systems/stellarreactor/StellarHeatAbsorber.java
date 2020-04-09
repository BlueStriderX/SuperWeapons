package net.dovtech.superweapons.blocks.systems.stellarreactor;

import org.schema.game.common.data.element.ElementInformation;

public class StellarHeatAbsorber {

    private ElementInformation blockInfo;

    public StellarHeatAbsorber() {
        blockInfo.setFullName("Stellar Heat Absorber");
        blockInfo.setDescription("Absorbs heat created by Stellar Reactor Coils and transforms it into usable Stellar Energy.");
        blockInfo.setArmorValue(1);
        blockInfo.setMaxHitPointsE(1);
        blockInfo.setBuildIconNum(0);
        blockInfo.setCanActivate(true);
        blockInfo.setShoppable(true);
        blockInfo.setAnimated(false);
        blockInfo.setEnterable(false);
        blockInfo.setProducedInFactory(1);
        blockInfo.setDoor(false);
    }

    public ElementInformation getBlockInfo() {
        return blockInfo;
    }
}

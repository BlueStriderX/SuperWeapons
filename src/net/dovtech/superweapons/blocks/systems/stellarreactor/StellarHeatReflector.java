package net.dovtech.superweapons.blocks.systems.stellarreactor;

import org.schema.game.common.data.element.ElementInformation;

public class StellarHeatReflector {

    private ElementInformation blockInfo;

    public StellarHeatReflector() {
        blockInfo.setFullName("Stellar Heat Reflector");
        blockInfo.setDescription("Reflects energy back to the reactor coils, which in turn heats them up even further to produce more Stellar Energy, but also makes the reactor more volatile. Connect this block to a ratio of ON and OFF Activation Modules to control how much heat is reflected back. The more modules that are ON than OFF, the more heat is reflected, and vice-versa.");
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

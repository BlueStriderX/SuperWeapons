package net.dovtech.superweapons.blocks.weapons;

import api.listener.events.block.BlockActivateEvent;
import org.schema.game.common.data.element.ElementInformation;

public class StellarAcceleratorComputer {

    private ElementInformation blockInfo;

    public StellarAcceleratorComputer() {
        blockInfo.setFullName("Stellar Accelerator Computer");
        blockInfo.setDescription("");
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

    public void onBlockActivation(BlockActivateEvent blockActivateEvent) {

    }
}
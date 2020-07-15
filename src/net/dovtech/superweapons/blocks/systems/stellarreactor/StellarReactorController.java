package net.dovtech.superweapons.blocks.systems.stellarreactor;

import net.dovtech.superweapons.systems.StellarReactorCoilGroup;
import org.schema.game.common.data.element.ElementInformation;
import java.util.ArrayList;

public class StellarReactorController {

    private ElementInformation blockInfo;
    private ArrayList<StellarReactorCoilGroup> coilGroups;

    public StellarReactorController() {
        blockInfo.setFullName("Stellar Reactor Controller");
        blockInfo.setDescription("Controls a Stellar Reactor. You can toggle the reactor on and off by connecting this block to an Activation Module.");
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

    public void addCoilGroup(StellarReactorCoilGroup coilGroup) {
        coilGroups.add(coilGroup);
    }
}

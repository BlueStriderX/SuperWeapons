package net.dovtech.superweapons.blocks.systems;

import org.schema.game.common.data.element.ElementInformation;

public class NeutroniumCapacitor {

    public static ElementInformation blockInfo;

    public NeutroniumCapacitor() {
        blockInfo.setFullName("Neutronium Capacitor");
        blockInfo.setDescription("Stores Neutronium within its banks.");
        blockInfo.setArmorValue(1);
        blockInfo.setMaxHitPointsE(1);
        blockInfo.setBuildIconNum(0);
        blockInfo.setCanActivate(true);
        blockInfo.setShoppable(true);
        blockInfo.setAnimated(false);
        blockInfo.setEnterable(false);
        blockInfo.setProducedInFactory(1);
        blockInfo.setDoor(false);
        blockInfo.setIndividualSides(1);
        blockInfo.setTextureId(new short[] { 776, 776, 776, 776, 776, 776 });
        blockInfo.systemBlock = true;
        blockInfo.controlledBy.add(StellarLifterController.blockInfo.getId());
    }
}
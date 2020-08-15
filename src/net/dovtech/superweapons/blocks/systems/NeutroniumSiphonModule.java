package net.dovtech.superweapons.blocks.systems;

import api.config.BlockConfig;
import org.schema.game.common.data.element.ElementInformation;

public class NeutroniumSiphonModule {

    public static ElementInformation blockInfo = BlockConfig.newElement("Neutronium Siphon Module");

    public NeutroniumSiphonModule() {
        blockInfo.setFullName("Neutronium Siphon Module");
        blockInfo.setDescription("Absorbs heat energy from Heat Reflectors and siphons it into connected capacity banks for further processing.");
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
        blockInfo.controlledBy.add(StellarLifterController.blockInfo.id);
    }
}

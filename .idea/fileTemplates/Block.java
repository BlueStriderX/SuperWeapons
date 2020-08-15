package ${PACKAGE_NAME};

import org.schema.game.common.data.element.ElementInformation;

public class ${NAME} {

    public static ElementInformation blockInfo;

    public ${NAME}() {
        blockInfo.setFullName("Display Name");
        blockInfo.setDescription("Description");
        blockInfo.setArmorValue(1);
        blockInfo.setMaxHitPointsE(1);
        blockInfo.setBuildIconNum(0);
        blockInfo.setCanActivate(false);
        blockInfo.setShoppable(true);
        blockInfo.setAnimated(false);
        blockInfo.setEnterable(false);
        blockInfo.setProducedInFactory(1);
        blockInfo.setDoor(false);
    }
}
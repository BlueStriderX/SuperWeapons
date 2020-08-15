package net.dovtech.superweapons.systems.neutroniumsiphon;

import org.schema.game.client.data.GameClientState;
import org.schema.game.client.view.gui.structurecontrol.ControllerManagerGUI;
import org.schema.game.common.controller.elements.ControlBlockElementCollectionManager;
import org.schema.game.common.data.element.ElementCollection;

public class NeutroniumSiphonUnit extends ElementCollection<NeutroniumSiphonUnit, NeutroniumSiphonCollectionManager, NeutroniumSiphonElementManager> {

    public NeutroniumSiphonUnit() {
    }

    public ControllerManagerGUI createUnitGUI(GameClientState clientState, ControlBlockElementCollectionManager<?, ?, ?> controlBlockCollectionManager1, ControlBlockElementCollectionManager<?, ?, ?> controlBlockCollectionManager2) {
        return ControllerManagerGUI.create(clientState, "Neutronium Siphon System", this, elementCollectionManager.getGUICollectionStats());
    }

    public boolean hasMesh() {
        return true;
    }
}

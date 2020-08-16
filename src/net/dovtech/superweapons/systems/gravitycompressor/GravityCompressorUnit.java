package net.dovtech.superweapons.systems.gravitycompressor;

import org.schema.game.client.data.GameClientState;
import org.schema.game.client.view.gui.structurecontrol.ControllerManagerGUI;
import org.schema.game.common.controller.elements.ControlBlockElementCollectionManager;
import org.schema.game.common.data.element.ElementCollection;

public class GravityCompressorUnit extends ElementCollection<GravityCompressorUnit, GravityCompressorCollectionManager, GravityCompressorElementManager> {

    public GravityCompressorUnit() {
    }

    public ControllerManagerGUI createUnitGUI(GameClientState clientState, ControlBlockElementCollectionManager<?, ?, ?> controlBlockCollectionManager1, ControlBlockElementCollectionManager<?, ?, ?> controlBlockCollectionManager2) {
        return ControllerManagerGUI.create(clientState, "Neutronium Siphon System", this, elementCollectionManager.getGUICollectionStats());
    }

    public boolean hasMesh() {
        return true;
    }
}

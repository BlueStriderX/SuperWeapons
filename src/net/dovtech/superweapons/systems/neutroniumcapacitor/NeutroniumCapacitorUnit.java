package net.dovtech.superweapons.systems.neutroniumcapacitor;

import org.schema.game.client.data.GameClientState;
import org.schema.game.client.view.gui.structurecontrol.ControllerManagerGUI;
import org.schema.game.common.controller.elements.ControlBlockElementCollectionManager;
import org.schema.game.common.controller.elements.VoidElementManager;
import org.schema.game.common.data.element.ElementCollection;

public class NeutroniumCapacitorUnit extends ElementCollection<NeutroniumCapacitorUnit, NeutroniumCapacitorCollectionManager, VoidElementManager<NeutroniumCapacitorUnit, NeutroniumCapacitorCollectionManager>> {

    public NeutroniumCapacitorUnit() {
    }

    public ControllerManagerGUI createUnitGUI(GameClientState clientState, ControlBlockElementCollectionManager<?, ?, ?> controlBlockCollectionManager1, ControlBlockElementCollectionManager<?, ?, ?> controlBlockCollectionManager2) {
        return ControllerManagerGUI.create(clientState, "Neutronium Capacitor Bank", this, elementCollectionManager.getGUICollectionStats());
    }

    public boolean hasMesh() {
        return true;
    }
}

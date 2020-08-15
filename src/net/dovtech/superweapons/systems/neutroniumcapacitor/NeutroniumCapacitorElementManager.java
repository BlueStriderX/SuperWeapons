package net.dovtech.superweapons.systems.neutroniumcapacitor;

import com.bulletphysics.linearmath.Transform;
import net.dovtech.superweapons.blocks.systems.NeutroniumCapacitor;
import net.dovtech.superweapons.blocks.systems.StellarLifterController;
import net.dovtech.superweapons.systems.heatreflector.HeatReflectorCollectionManager;
import org.schema.game.client.data.GameClientState;
import org.schema.game.client.view.gui.structurecontrol.ControllerManagerGUI;
import org.schema.game.common.controller.SegmentController;
import org.schema.game.common.controller.elements.ControlBlockElementCollectionManager;
import org.schema.game.common.controller.elements.UsableControllableElementManager;
import org.schema.game.common.data.SegmentPiece;
import org.schema.game.common.data.player.ControllerStateInterface;
import org.schema.schine.graphicsengine.core.Timer;

public class NeutroniumCapacitorElementManager extends UsableControllableElementManager<NeutroniumCapacitorUnit, NeutroniumCapacitorCollectionManager, NeutroniumCapacitorElementManager> {

    public NeutroniumCapacitorElementManager(SegmentController segmentController) {
        super(StellarLifterController.blockInfo.getId(), NeutroniumCapacitor.blockInfo.getId(), segmentController);
    }

    @Override
    public ControllerManagerGUI getGUIUnitValues(NeutroniumCapacitorUnit neutroniumCapacitorUnit, NeutroniumCapacitorCollectionManager neutroniumCapacitorCollectionManager, ControlBlockElementCollectionManager<?, ?, ?> controlBlockElementCollectionManager, ControlBlockElementCollectionManager<?, ?, ?> controlBlockElementCollectionManager1) {
        return ControllerManagerGUI.create((GameClientState)this.getState(), "Neutronium Capacitor Bank", neutroniumCapacitorUnit);
    }

    @Override
    protected String getTag() {
        return "mainreactor";
    }

    @Override
    public NeutroniumCapacitorCollectionManager getNewCollectionManager(SegmentPiece segmentPiece, Class<NeutroniumCapacitorCollectionManager> aClass) {
        return new NeutroniumCapacitorCollectionManager(segmentPiece, this.getSegmentController(), this);
    }

    @Override
    public String getManagerName() {
        return "Neutronium Capacitor Bank";
    }

    @Override
    protected void playSound(NeutroniumCapacitorUnit neutroniumCapacitorUnit, Transform transform) {

    }

    @Override
    public void handle(ControllerStateInterface controllerStateInterface, Timer timer) {

    }
}

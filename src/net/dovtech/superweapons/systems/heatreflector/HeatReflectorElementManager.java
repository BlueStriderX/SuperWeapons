package net.dovtech.superweapons.systems.heatreflector;

import net.dovtech.superweapons.blocks.systems.HeatReflector;
import net.dovtech.superweapons.blocks.systems.StellarLifterController;
import org.schema.game.client.data.GameClientState;
import org.schema.game.client.view.gui.structurecontrol.ControllerManagerGUI;
import org.schema.game.common.controller.SegmentController;
import org.schema.game.common.controller.elements.*;
import org.schema.game.common.data.SegmentPiece;
import org.schema.game.common.data.player.ControllerStateInterface;
import org.schema.schine.graphicsengine.core.Timer;

public class HeatReflectorElementManager extends UsableControllableElementManager<HeatReflectorUnit, HeatReflectorCollectionManager, HeatReflectorElementManager> {

    public HeatReflectorElementManager(SegmentController segmentController) {
        super(StellarLifterController.blockInfo.getId(), HeatReflector.blockInfo.getId(), segmentController);
    }

    @Override
    public ControllerManagerGUI getGUIUnitValues(HeatReflectorUnit heatReflectorUnit, HeatReflectorCollectionManager heatReflectorCollectionManager, ControlBlockElementCollectionManager<?, ?, ?> controlBlockElementCollectionManager, ControlBlockElementCollectionManager<?, ?, ?> controlBlockElementCollectionManager1) {
        return ControllerManagerGUI.create((GameClientState)this.getState(), "Heat Reflector Array System", heatReflectorUnit);
    }

    @Override
    protected String getTag() {
        return "mainreactor";
    }

    @Override
    public HeatReflectorCollectionManager getNewCollectionManager(SegmentPiece segmentPiece, Class<HeatReflectorCollectionManager> aClass) {
        return new HeatReflectorCollectionManager(segmentPiece, this.getSegmentController(), this);
    }

    @Override
    public String getManagerName() {
        return "Heat Reflector Array System";
    }

    @Override
    protected void playSound(HeatReflectorUnit heatReflectorUnit, com.bulletphysics.linearmath.Transform transform) {

    }

    @Override
    public void handle(ControllerStateInterface controllerStateInterface, Timer timer) {

    }
}

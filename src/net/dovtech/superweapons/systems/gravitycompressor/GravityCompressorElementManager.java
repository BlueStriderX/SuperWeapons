package net.dovtech.superweapons.systems.gravitycompressor;

import com.bulletphysics.linearmath.Transform;
import net.dovtech.superweapons.blocks.systems.GravityCompressorController;
import net.dovtech.superweapons.blocks.systems.GravityCompressorModule;
import org.schema.game.client.data.GameClientState;
import org.schema.game.client.view.gui.structurecontrol.ControllerManagerGUI;
import org.schema.game.common.controller.SegmentController;
import org.schema.game.common.controller.elements.ControlBlockElementCollectionManager;
import org.schema.game.common.controller.elements.UsableControllableElementManager;
import org.schema.game.common.data.SegmentPiece;
import org.schema.game.common.data.player.ControllerStateInterface;
import org.schema.schine.graphicsengine.core.Timer;

public class GravityCompressorElementManager extends UsableControllableElementManager<GravityCompressorUnit, GravityCompressorCollectionManager, GravityCompressorElementManager> {

    public GravityCompressorElementManager(SegmentController segmentController) {
        super(GravityCompressorController.blockInfo.getId(), GravityCompressorModule.blockInfo.getId(), segmentController);
    }

    @Override
    public ControllerManagerGUI getGUIUnitValues(GravityCompressorUnit gravityCompressorUnit, GravityCompressorCollectionManager gravityCompressorCollectionManager, ControlBlockElementCollectionManager<?, ?, ?> controlBlockElementCollectionManager, ControlBlockElementCollectionManager<?, ?, ?> controlBlockElementCollectionManager1) {
        return ControllerManagerGUI.create((GameClientState)this.getState(), "Neutronium Siphon System", gravityCompressorUnit);
    }

    @Override
    protected String getTag() {
        return "mainreactor";
    }

    @Override
    public GravityCompressorCollectionManager getNewCollectionManager(SegmentPiece segmentPiece, Class<GravityCompressorCollectionManager> aClass) {
        return new GravityCompressorCollectionManager(segmentPiece, this.getSegmentController(), this);
    }

    @Override
    public String getManagerName() {
        return "Neutronium Siphon System";
    }

    @Override
    protected void playSound(GravityCompressorUnit gravityCompressorUnit, Transform transform) {

    }

    @Override
    public void handle(ControllerStateInterface controllerStateInterface, Timer timer) {

    }
}

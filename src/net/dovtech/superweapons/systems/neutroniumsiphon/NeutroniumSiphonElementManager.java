package net.dovtech.superweapons.systems.neutroniumsiphon;

import com.bulletphysics.linearmath.Transform;
import net.dovtech.superweapons.blocks.systems.NeutroniumCapacitor;
import net.dovtech.superweapons.blocks.systems.NeutroniumSiphonController;
import net.dovtech.superweapons.blocks.systems.NeutroniumSiphonModule;
import net.dovtech.superweapons.blocks.systems.StellarLifterController;
import org.schema.game.client.data.GameClientState;
import org.schema.game.client.view.gui.structurecontrol.ControllerManagerGUI;
import org.schema.game.common.controller.SegmentController;
import org.schema.game.common.controller.elements.ControlBlockElementCollectionManager;
import org.schema.game.common.controller.elements.UsableControllableElementManager;
import org.schema.game.common.data.SegmentPiece;
import org.schema.game.common.data.player.ControllerStateInterface;
import org.schema.schine.graphicsengine.core.Timer;

public class NeutroniumSiphonElementManager extends UsableControllableElementManager<NeutroniumSiphonUnit, NeutroniumSiphonCollectionManager, NeutroniumSiphonElementManager> {

    public NeutroniumSiphonElementManager(SegmentController segmentController) {
        super(NeutroniumSiphonController.blockInfo.getId(), NeutroniumSiphonModule.blockInfo.getId(), segmentController);
    }

    @Override
    public ControllerManagerGUI getGUIUnitValues(NeutroniumSiphonUnit neutroniumSiphonUnit, NeutroniumSiphonCollectionManager neutroniumSiphonCollectionManager, ControlBlockElementCollectionManager<?, ?, ?> controlBlockElementCollectionManager, ControlBlockElementCollectionManager<?, ?, ?> controlBlockElementCollectionManager1) {
        return ControllerManagerGUI.create((GameClientState)this.getState(), "Neutronium Siphon System", neutroniumSiphonUnit);
    }

    @Override
    protected String getTag() {
        return "mainreactor";
    }

    @Override
    public NeutroniumSiphonCollectionManager getNewCollectionManager(SegmentPiece segmentPiece, Class<NeutroniumSiphonCollectionManager> aClass) {
        return new NeutroniumSiphonCollectionManager(segmentPiece, this.getSegmentController(), this);
    }

    @Override
    public String getManagerName() {
        return "Neutronium Siphon System";
    }

    @Override
    protected void playSound(NeutroniumSiphonUnit neutroniumSiphonUnit, Transform transform) {

    }

    @Override
    public void handle(ControllerStateInterface controllerStateInterface, Timer timer) {

    }
}

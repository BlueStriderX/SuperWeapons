package net.dovtech.superweapons.systems.neutroniumsiphon;

import net.dovtech.superweapons.blocks.systems.NeutroniumSiphonController;
import org.schema.game.client.view.gui.structurecontrol.GUIKeyValueEntry;
import org.schema.game.client.view.gui.structurecontrol.ModuleValueEntry;
import org.schema.game.common.controller.SegmentController;
import org.schema.game.common.controller.elements.ControlBlockElementCollectionManager;
import org.schema.game.common.data.SegmentPiece;

public class NeutroniumSiphonCollectionManager extends ControlBlockElementCollectionManager<NeutroniumSiphonUnit, NeutroniumSiphonCollectionManager, NeutroniumSiphonElementManager> {

    public NeutroniumSiphonCollectionManager(SegmentPiece segmentPiece, SegmentController segmentController, NeutroniumSiphonElementManager neutroniumSiphonElementManager) {
        super(segmentPiece, NeutroniumSiphonController.blockInfo.getId(), segmentController, neutroniumSiphonElementManager);
    }

    @Override
    public int getMargin() {
        return 0;
    }

    @Override
    protected Class<NeutroniumSiphonUnit> getType() {
        return NeutroniumSiphonUnit.class;
    }

    @Override
    public boolean needsUpdate() {
        return false;
    }

    @Override
    public NeutroniumSiphonUnit getInstance() {
        return new NeutroniumSiphonUnit();
    }

    @Override
    public GUIKeyValueEntry[] getGUICollectionStats() {
        return new GUIKeyValueEntry[] {new ModuleValueEntry("Size", getElementCollections().size())};

    }

    @Override
    public String getModuleName() {
        return "Neutronium Siphon System";
    }
}

package net.dovtech.superweapons.systems.gravitycompressor;

import net.dovtech.superweapons.blocks.systems.GravityCompressorController;
import org.schema.game.client.view.gui.structurecontrol.GUIKeyValueEntry;
import org.schema.game.client.view.gui.structurecontrol.ModuleValueEntry;
import org.schema.game.common.controller.SegmentController;
import org.schema.game.common.controller.elements.ControlBlockElementCollectionManager;
import org.schema.game.common.data.SegmentPiece;

public class GravityCompressorCollectionManager extends ControlBlockElementCollectionManager<GravityCompressorUnit, GravityCompressorCollectionManager, GravityCompressorElementManager> {

    public GravityCompressorCollectionManager(SegmentPiece segmentPiece, SegmentController segmentController, GravityCompressorElementManager gravityCompressorElementManager) {
        super(segmentPiece, GravityCompressorController.blockInfo.getId(), segmentController, gravityCompressorElementManager);
    }

    @Override
    public int getMargin() {
        return 0;
    }

    @Override
    protected Class<GravityCompressorUnit> getType() {
        return GravityCompressorUnit.class;
    }

    @Override
    public boolean needsUpdate() {
        return false;
    }

    @Override
    public GravityCompressorUnit getInstance() {
        return new GravityCompressorUnit();
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

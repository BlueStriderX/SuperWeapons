package net.dovtech.superweapons.systems.heatreflector;

import net.dovtech.superweapons.blocks.systems.StellarLifterController;
import org.schema.game.common.controller.SegmentController;
import org.schema.game.common.controller.elements.ControlBlockElementCollectionManager;
import org.schema.game.common.data.SegmentPiece;
import java.util.Comparator;

public class HeatReflectorCollectionManager extends ControlBlockElementCollectionManager<HeatReflectorUnit, HeatReflectorCollectionManager, HeatReflectorElementManager> implements Comparator<HeatReflectorUnit> {

    public HeatReflectorCollectionManager(SegmentPiece segmentPiece, SegmentController segmentController, HeatReflectorElementManager heatReflectorElementManager) {
        super(segmentPiece, StellarLifterController.blockInfo.getId(), segmentController, heatReflectorElementManager);
    }

    @Override
    public int compare(HeatReflectorUnit o1, HeatReflectorUnit o2) {
        return o2.normalPos - o1.normalPos;
    }

    @Override
    protected Class<HeatReflectorUnit> getType() {
        return HeatReflectorUnit.class;
    }

    @Override
    public HeatReflectorUnit getInstance() {
        return new HeatReflectorUnit();
    }

    @Override
    public String getModuleName() {
        return "Heat Reflector Module";
    }

    public CollectionShape requiredNeigborsPerBlock() {
        return CollectionShape.LOOP;
    }
}

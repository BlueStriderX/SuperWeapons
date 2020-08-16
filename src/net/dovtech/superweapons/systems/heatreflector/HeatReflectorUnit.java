package net.dovtech.superweapons.systems.heatreflector;

import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import org.schema.common.LogUtil;
import org.schema.common.util.linAlg.Vector3i;
import org.schema.game.client.data.GameClientState;
import org.schema.game.client.view.gui.structurecontrol.ControllerManagerGUI;
import org.schema.game.common.controller.elements.ControlBlockElementCollectionManager;
import org.schema.game.common.data.element.ElementCollection;

public class HeatReflectorUnit extends ElementCollection<HeatReflectorUnit, HeatReflectorCollectionManager, HeatReflectorElementManager> {

    final Vector3i min = new Vector3i();
    final Vector3i max = new Vector3i();
    public int xDelta;
    public int yDelta;
    public int zDelta;
    public boolean xDim;
    public boolean yDim;
    public boolean zDim;
    private String invalidReason;
    public int normalPos;

    public HeatReflectorUnit() {

    }

    public boolean isValid() {
        return (this.xDim || this.yDim || this.zDim) && super.isValid();
    }

    public String toString() {
        return "HeatReflectorUnit " + super.toString();
    }

    @Override
    public ControllerManagerGUI createUnitGUI(GameClientState gameClientState, ControlBlockElementCollectionManager<?, ?, ?> controlBlockElementCollectionManager, ControlBlockElementCollectionManager<?, ?, ?> controlBlockElementCollectionManager1) {
        return this.elementCollectionManager.getElementManager().getGUIUnitValues(this, this.elementCollectionManager, controlBlockElementCollectionManager, controlBlockElementCollectionManager1);
    }

    public void calculateExtraDataAfterCreationThreaded(long var1, LongOpenHashSet var3) {
        this.getMin(this.min);
        this.getMax(this.max);
        this.xDelta = this.max.x - this.min.x;
        this.yDelta = this.max.y - this.min.y;
        this.zDelta = this.max.z - this.min.z;
        this.xDim = this.xDelta == 1 && this.yDelta > 1 && this.zDelta > 1;
        this.yDim = this.xDelta > 1 && this.yDelta == 1 && this.zDelta > 1;
        this.zDim = this.xDelta > 1 && this.yDelta > 1 && this.zDelta == 1;
        if (!this.xDim && !this.yDim && !this.zDim) {
            this.setInvalidReason("Invalid Heat Reflector Array shape");
            LogUtil.sy().fine(this.getSegmentController() + "; " + this + " Invalid Heat Reflector Array shape");
        } else {
            LogUtil.sy().fine(this.getSegmentController() + "; " + this + " Valid Heat Reflector Array shape");
        }
    }

    public String getInvalidReason() {
        return this.invalidReason;
    }

    public void setInvalidReason(String var1) {
        this.invalidReason = var1;
    }

    public boolean hasMesh() {
        return true;
    }
}

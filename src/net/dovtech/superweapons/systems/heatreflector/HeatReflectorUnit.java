package net.dovtech.superweapons.systems.heatreflector;

import com.bulletphysics.linearmath.Transform;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import org.schema.common.LogUtil;
import org.schema.common.util.linAlg.Vector3i;
import org.schema.game.client.data.GameClientState;
import org.schema.game.client.view.gui.structurecontrol.ControllerManagerGUI;
import org.schema.game.common.controller.elements.ControlBlockElementCollectionManager;
import org.schema.game.common.data.element.ElementCollection;
import org.schema.schine.common.language.Lng;
import org.schema.schine.graphicsengine.core.settings.EngineSettings;
import org.schema.schine.graphicsengine.forms.DebugBox;
import org.schema.schine.graphicsengine.forms.debug.DebugDrawer;
import javax.vecmath.Vector3f;

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
        return ((HeatReflectorElementManager)((HeatReflectorCollectionManager)this.elementCollectionManager).getElementManager()).getGUIUnitValues(this, (HeatReflectorCollectionManager)this.elementCollectionManager, controlBlockElementCollectionManager, controlBlockElementCollectionManager1);
    }

    public String getValidInfo() {
        boolean var1 = this.xDim || this.yDim || this.zDim;
        return "DimOK: " + var1 + " (" + this.xDelta + ", " + this.yDelta + ", " + this.zDelta + "); 2Neighbors: " + super.isValid();
    }

    public void debugDraw(Vector3i var1) {
        this.debugDraw(var1.x, var1.y, var1.z);
    }

    public void debugDraw(int var1, int var2, int var3) {
        if (EngineSettings.P_PHYSICS_DEBUG_ACTIVE.isOn()) {
            Transform var4 = new Transform(this.getSegmentController().getWorldTransform());
            Vector3f var5;
            (var5 = new Vector3f()).set((float)var1, (float)var2, (float)var3);
            var5.x -= 16.0F;
            var5.y -= 16.0F;
            var5.z -= 16.0F;
            var4.basis.transform(var5);
            var4.origin.add(var5);
            DebugBox var6;
            (var6 = new DebugBox(new Vector3f(-0.51F, -0.51F, -0.51F), new Vector3f(0.51F, 0.51F, 0.51F), var4, 1.0F, 0.0F, 0.0F, 1.0F)).LIFETIME = 200L;
            DebugDrawer.boxes.add(var6);
        }

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
            this.setInvalidReason(Lng.ORG_SCHEMA_GAME_COMMON_CONTROLLER_ELEMENTS_SHIPYARD_SHIPYARDUNIT_0);
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
}

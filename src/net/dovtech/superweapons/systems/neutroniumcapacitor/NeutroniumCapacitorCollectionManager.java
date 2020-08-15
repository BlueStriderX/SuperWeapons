package net.dovtech.superweapons.systems.neutroniumcapacitor;

import api.DebugFile;
import net.dovtech.superweapons.SuperWeapons;
import net.dovtech.superweapons.blocks.systems.StellarLifterController;
import org.schema.common.util.StringTools;
import org.schema.game.client.view.gui.structurecontrol.GUIKeyValueEntry;
import org.schema.game.client.view.gui.structurecontrol.ModuleValue2Entry;
import org.schema.game.client.view.gui.structurecontrol.ModuleValueEntry;
import org.schema.game.common.controller.SegmentController;
import org.schema.game.common.controller.damage.Damager;
import org.schema.game.common.controller.elements.*;
import org.schema.game.common.data.SegmentPiece;

public class NeutroniumCapacitorCollectionManager extends ControlBlockElementCollectionManager<NeutroniumCapacitorUnit, NeutroniumCapacitorCollectionManager, NeutroniumCapacitorElementManager> {

    private double currentCapacity;
    private double maxCapacity;

    public NeutroniumCapacitorCollectionManager(SegmentPiece segmentPiece, SegmentController segmentController, NeutroniumCapacitorElementManager neutroniumCapacitorElementManager) {
        super(segmentPiece, StellarLifterController.blockInfo.getId(), segmentController, neutroniumCapacitorElementManager);
    }

    @Override
    public int getMargin() {
        return 0;
    }

    @Override
    protected Class<NeutroniumCapacitorUnit> getType() {
        return NeutroniumCapacitorUnit.class;
    }

    @Override
    public boolean needsUpdate() {
        return false;
    }

    @Override
    public NeutroniumCapacitorUnit getInstance() {
        return null;
    }

    @Override
    public void onChangedCollection() {
        refreshStats();
    }

    @Override
    public GUIKeyValueEntry[] getGUICollectionStats() {
        return new GUIKeyValueEntry[] {new ModuleValueEntry("Size", getElementCollections().size()), new ModuleValue2Entry("Current Neutronium", StringTools.formatPointZero(getCurrentCapacity()), StringTools.formatPointZero(getMaxCapacity()))};
    }

    @Override
    public String getModuleName() {
        return "Neutronium Capacitor Bank";
    }

    private void refreshStats() {
        maxCapacity = getElementCollections().size() * SuperWeapons.getInst().getConfig("config").getDouble("neutronium-capacity-per-block");
        currentCapacity = Math.min(currentCapacity, maxCapacity);

        if(SuperWeapons.getInst().debugMode) DebugFile.log("[DEBUG]: Found Neutronium Capacitor Bank of size " + getElementCollections().size());
        if(SuperWeapons.getInst().debugMode) DebugFile.log("[DEBUG]: Neutronium Capacitor Bank has [" + StringTools.formatPointZero(currentCapacity) + "/" + StringTools.formatPointZero(maxCapacity) + "] energy");

    }

    public double getCurrentCapacity() {
        return currentCapacity;
    }

    public double getMaxCapacity() {
        return maxCapacity;
    }
}

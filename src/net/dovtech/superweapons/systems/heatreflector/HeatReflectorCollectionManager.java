package net.dovtech.superweapons.systems.heatreflector;

import net.dovtech.superweapons.blocks.systems.StellarLifterController;
import org.schema.game.common.controller.SegmentController;
import org.schema.game.common.controller.elements.ControlBlockElementCollectionManager;
import org.schema.game.common.controller.elements.power.reactor.PowerConsumer;
import org.schema.game.common.data.SegmentPiece;
import org.schema.game.common.data.blockeffects.config.StatusEffectType;
import org.schema.schine.graphicsengine.core.Timer;
import java.util.Comparator;

public class HeatReflectorCollectionManager extends ControlBlockElementCollectionManager<HeatReflectorUnit, HeatReflectorCollectionManager, HeatReflectorElementManager> implements PowerConsumer, Comparator<HeatReflectorUnit> {

    private float powered;

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

    private double getReactorPowerUsage() {
        double var1 = HeatReflectorElementManager.REACTOR_POWER_CONSUMPTION_RESTING * (double)this.getTotalSize();
        return this.getConfigManager().apply(StatusEffectType.WARP_POWER_EFFICIENCY, var1);
    }

    @Override
    public double getPowerConsumedPerSecondResting() {
        return this.getReactorPowerUsage();
    }

    @Override
    public double getPowerConsumedPerSecondCharging() {
        return this.getReactorPowerUsage();
    }

    @Override
    public boolean isPowerCharging(long l) {
        return true;
    }

    @Override
    public void setPowered(float v) {
        this.powered = v;
    }

    @Override
    public float getPowered() {
        return this.powered;
    }

    @Override
    public PowerConsumerCategory getPowerConsumerCategory() {
        return PowerConsumerCategory.MINING_BEAMS;
    }

    @Override
    public void reloadFromReactor(double v, Timer timer, float v1, boolean b, float v2) {

    }

    @Override
    public boolean isPowerConsumerActive() {
        return true;
    }

    @Override
    public void dischargeFully() {
    }

    public CollectionShape requiredNeigborsPerBlock() {
        return CollectionShape.LOOP;
    }
}

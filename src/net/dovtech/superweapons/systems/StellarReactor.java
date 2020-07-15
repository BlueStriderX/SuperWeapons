package net.dovtech.superweapons.systems;

import java.util.Map;

public class StellarReactor {

    private Map<StellarReactorCoilGroup, Float> coilGroups;

    public StellarReactor() {

    }

    public void addCoilGroup(StellarReactorCoilGroup coilGroup) {
        coilGroups.put(coilGroup, calculateEnergy(coilGroup));
    }

    private float calculateEnergy(StellarReactorCoilGroup coilGroup) {
        float energy = 0;


        return energy;
    }
}

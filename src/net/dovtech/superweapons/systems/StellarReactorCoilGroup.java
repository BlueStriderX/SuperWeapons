package net.dovtech.superweapons.systems;

import api.systems.multiblock.MultiblockSystem;
import java.util.ArrayList;

public class StellarReactorCoilGroup {

    private ArrayList<MultiblockSystem> multiBlocks = new ArrayList<>();

    public StellarReactorCoilGroup() {
        //Level 1
        MultiblockSystem level1 = new MultiblockSystem("Stellar Reactor Controller");
        char[][][] layout1 = {
            {   //Layer 1
                { '0', '0', 'r', '0', '0' },
                { '0', 'a', 'a', 'a', '0' },
                { 'r', 'a', 'a', 'a', 'r' },
                { '0', 'a', 'a', 'a', '0' },
                { '0', '0', 'r', '0', '0' }
            },{ //Layer 2
                { 'c', 'c', 'r', 'c', 'c' },
                { 'c', 'a', 'a', 'a', 'c' },
                { 'r', 'a', 'a', 'a', 'r' },
                { 'c', 'a', 'a', 'a', 'c' },
                { 'c', 'c', 'r', 'c', 'c' }
            },{ //Layer 3
                { '0', '0', 'r', '0', '0' },
                { '0', 'a', 'a', 'a', '0' },
                { 'r', 'a', 'a', 'a', 'r' },
                { '0', 'a', 'a', 'a', '0' },
                { '0', '0', 'r', '0', '0' }
            },{ //Layer 4
                { 'c', 'c', 'r', 'c', 'c' },
                { 'c', 'a', 'a', 'a', 'c' },
                { 'r', 'a', 'a', 'a', 'r' },
                { 'c', 'a', 'a', 'a', 'c' },
                { 'c', 'c', 'r', 'c', 'c' }
            },{ //Layer 5
                { '0', '0', 'r', '0', '0' },
                { '0', 'a', 'a', 'a', '0' },
                { 'r', 'a', 'a', 'a', 'r' },
                { '0', 'a', 'a', 'a', '0' },
                { '0', '0', 'r', '0', '0' }
            }
        };
        level1.setBlock('r', "Stellar Heat Reflector");
        level1.setBlock('c', "Stellar Reactor Coil");
        level1.setBlock('a', "Stellar Heat Absorber");
        multiBlocks.set(0, level1);
    }

    public ArrayList<MultiblockSystem> getMultiblocks() {
        return multiBlocks;
    }
}
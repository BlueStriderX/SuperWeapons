package net.dovtech.superweapons;

import api.DebugFile;
import api.config.BlockConfig;
import api.mod.StarMod;

public class SuperWeapons extends StarMod {
    static SuperWeapons inst;
    public SuperWeapons() {
        inst = this;
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.modName = "SuperWeapons";
        this.modAuthor = "DovTech";
        this.modVersion = "0.0.1";
        this.modDescription = "Adds powerful superweapons to annihilate your enemies.";
        DebugFile.log("Enabled", this);

    }

    public void onBlockConfigLoad(BlockConfig config) {

        /*
        //Fleet Manager
        FleetManager fleetManager = new FleetManager();
        ElementInformation fleetManagerInfo = fleetManager.getBlockInfo();
        FactoryResource[] fleetManagerRecipe = {
                new FactoryResource(1, Blocks.STORAGE.getId()),
                new FactoryResource(5, Blocks.FACTION_MODULE.getId()),
                new FactoryResource(5, Blocks.BOBBY_AI_MODULE.getId())
        };
        BlockConfig.addRecipe(fleetManagerInfo, FactoryType.ADVANCED, 5, fleetManagerRecipe);
        config.add(fleetManagerInfo);

         */
    }
}
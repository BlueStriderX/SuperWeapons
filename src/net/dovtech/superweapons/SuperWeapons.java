package net.dovtech.superweapons;

import api.DebugFile;
import api.config.BlockConfig;
import api.element.block.Blocks;
import api.listener.Listener;
import api.listener.events.register.ElementRegisterEvent;
import api.mod.StarLoader;
import api.mod.StarMod;
import api.mod.config.FileConfiguration;
import net.dovtech.superweapons.blocks.systems.*;
import net.dovtech.superweapons.systems.heatreflector.HeatReflectorElementManager;
import net.dovtech.superweapons.systems.neutroniumcapacitor.NeutroniumCapacitorElementManager;
import net.dovtech.superweapons.systems.neutroniumsiphon.NeutroniumSiphonElementManager;
import org.schema.game.common.controller.elements.ManagerModuleCollection;
import org.schema.game.common.data.element.FactoryResource;

public class SuperWeapons extends StarMod {
    static SuperWeapons inst;
    public SuperWeapons() {
        inst = this;
    }

    public boolean debugMode;

    public static void main(String[] args) {

    }

    @Override
    public void onEnable() {
        super.onEnable();
        DebugFile.log("Enabled", this);
        initConfig();
    }

    @Override
    public void onGameStart() {
        this.setModName("SuperWeapons");
        this.setModAuthor("TheDerpGamer");
        this.setModVersion("0.1.5");
        this.setModDescription("Adds powerful new systems for your mighty empire.");
    }

    private void initConfig() {
        FileConfiguration config = getConfig("config");
        config.saveDefault(
                "debug-mode: false",
                "neutronium-capacity-per-block: 150.0"
        );

        debugMode = Boolean.parseBoolean(config.getString("debug-mode"));
    }

    @Override
    public void onBlockConfigLoad(BlockConfig config) {
        /* Factory Types:
        0 = NONE
        1 = CAPSULE REFINERY
        2 = MICRO ASSEMBLER
        3 = BASIC FACTORY
        4 = STANDARD FACTORY
        5 = ADVANCED FACTORY
         */

        //Create Blocks
        StellarLifterController.blockInfo = config.newElement("Stellar Lifter Controller");
        NeutroniumSiphonController.blockInfo = config.newElement("Neutronium Siphon Controller");
        NeutroniumSiphonModule.blockInfo = config.newElement("Neutronium Siphon Module");
        NeutroniumCapacitor.blockInfo = config.newElement("Neutronium Capacitor");
        HeatReflector.blockInfo = config.newElement("Heat Reflector");

        //Initialize Blocks
        new StellarLifterController();
        new NeutroniumSiphonController();
        new NeutroniumSiphonModule();
        new NeutroniumCapacitor();
        new HeatReflector();

        //Add Recipes
        FactoryResource[] stellarLifterControllerRecipe = {
                new FactoryResource(5000, Blocks.REACTOR_POWER.getId()),
                new FactoryResource(5000, Blocks.REACTOR_STABILIZER.getId()),
                new FactoryResource(300, Blocks.POWER_SUPPLY_COMPUTER.getId()),
                new FactoryResource(300, Blocks.SALVAGE_COMPUTER.getId())
        };
        BlockConfig.addRecipe(StellarLifterController.blockInfo, 5, 50, stellarLifterControllerRecipe);
        FactoryResource[] neutroniumSiphonController = {
                new FactoryResource(100, Blocks.REACTOR_STABILIZER.getId()),
                new FactoryResource(50, Blocks.SALVAGE_COMPUTER.getId()),
                new FactoryResource(50, Blocks.POWER_SUPPLY_COMPUTER.getId()),
                new FactoryResource(30, Blocks.THRENS_INGOT.getId())
        };
        BlockConfig.addRecipe(NeutroniumSiphonController.blockInfo, 5, 15, neutroniumSiphonController);
        FactoryResource[] neutroniumSiphonRecipe = {
                new FactoryResource(10, Blocks.REACTOR_STABILIZER.getId()),
                new FactoryResource(30, Blocks.SALVAGE_MODULE.getId()),
                new FactoryResource(30, Blocks.POWER_SUPPLY_MODULE.getId()),
                new FactoryResource(5, Blocks.THRENS_INGOT.getId())
        };
        BlockConfig.addRecipe(NeutroniumSiphonModule.blockInfo, 5, 15, neutroniumSiphonRecipe);
        FactoryResource[] neutroniumCapacitorRecipe = {
                new FactoryResource(10, Blocks.REACTOR_STABILIZER.getId()),
                new FactoryResource(10, Blocks.SHIELD_CAPACITOR.getId()),
                new FactoryResource(5, Blocks.THRENS_INGOT.getId())
        };
        BlockConfig.addRecipe(NeutroniumCapacitor.blockInfo, 5, 15, neutroniumCapacitorRecipe);
        FactoryResource[] heatReflectorRecipe = {
                new FactoryResource(15, Blocks.REACTOR_STABILIZER.getId()),
                new FactoryResource(50, Blocks.GLASS.getId()),
                new FactoryResource(15, Blocks.THRENS_INGOT.getId()),
                new FactoryResource(5, Blocks.SHIELD_CAPACITOR.getId())
        };
        BlockConfig.addRecipe(HeatReflector.blockInfo, 4, 10, heatReflectorRecipe);

        //Register Blocks
        config.add(StellarLifterController.blockInfo);
        config.add(NeutroniumSiphonController.blockInfo);
        config.add(NeutroniumSiphonModule.blockInfo);
        config.add(NeutroniumCapacitor.blockInfo);
        config.add(HeatReflector.blockInfo);

        if(debugMode) DebugFile.log("[DEBUG]: Registered blocks");


        StarLoader.registerListener(ElementRegisterEvent.class, new Listener<ElementRegisterEvent>() {
            @Override
            public void onEvent(ElementRegisterEvent elementRegisterEvent) {
                elementRegisterEvent.addModuleCollection(new ManagerModuleCollection(new HeatReflectorElementManager(elementRegisterEvent.getSegmentController()), StellarLifterController.blockInfo.getId(), HeatReflector.blockInfo.getId()));
                elementRegisterEvent.addModuleCollection(new ManagerModuleCollection(new NeutroniumCapacitorElementManager(elementRegisterEvent.getSegmentController()), StellarLifterController.blockInfo.getId(), NeutroniumCapacitor.blockInfo.getId()));
                elementRegisterEvent.addModuleCollection(new ManagerModuleCollection(new NeutroniumSiphonElementManager(elementRegisterEvent.getSegmentController()), NeutroniumSiphonController.blockInfo.getId(), NeutroniumSiphonModule.blockInfo.getId()));
            }
        });
    }

    public static SuperWeapons getInst() {
        return inst;
    }
}
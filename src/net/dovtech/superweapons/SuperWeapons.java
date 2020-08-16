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
import net.dovtech.superweapons.systems.gravitycompressor.GravityCompressorElementManager;
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
        //Texture ID Places: { FRONT, BACK, TOP, BOTTOM, LEFT, RIGHT }
        StellarLifterController.blockInfo = config.newElement("Stellar Lifter Controller", new short[] { 373, 769, 371, 377, 770, 770 });
        GravityCompressorController.blockInfo = config.newElement("Gravity Compressor Controller", new short[] { 374, 771, 371, 377, 772, 772 });
        GravityCompressorModule.blockInfo = config.newElement("Gravity Compressor Module", new short[] { 773, 774, 775, 775, 774, 774 });
        NeutroniumCapacitor.blockInfo = config.newElement("Neutronium Capacitor", new short[] { 776, 776, 776, 776, 776, 776 });
        HeatReflector.blockInfo = config.newElement("Heat Reflector");

        //Initialize Blocks
        new StellarLifterController();
        new GravityCompressorController();
        new GravityCompressorModule();
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
        FactoryResource[] gravityCompressorControllerRecipe = {
                new FactoryResource(100, Blocks.REACTOR_STABILIZER.getId()),
                new FactoryResource(50, Blocks.SALVAGE_COMPUTER.getId()),
                new FactoryResource(50, Blocks.POWER_SUPPLY_COMPUTER.getId()),
                new FactoryResource(30, Blocks.THRENS_INGOT.getId())
        };
        BlockConfig.addRecipe(GravityCompressorController.blockInfo, 5, 15, gravityCompressorControllerRecipe);
        FactoryResource[] gravityCompressorModuleRecipe = {
                new FactoryResource(10, Blocks.REACTOR_STABILIZER.getId()),
                new FactoryResource(30, Blocks.SALVAGE_MODULE.getId()),
                new FactoryResource(30, Blocks.POWER_SUPPLY_MODULE.getId()),
                new FactoryResource(5, Blocks.THRENS_INGOT.getId())
        };
        BlockConfig.addRecipe(GravityCompressorModule.blockInfo, 5, 15, gravityCompressorModuleRecipe);
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
        config.add(GravityCompressorController.blockInfo);
        config.add(GravityCompressorModule.blockInfo);
        config.add(NeutroniumCapacitor.blockInfo);
        config.add(HeatReflector.blockInfo);

        if(debugMode) DebugFile.log("[DEBUG]: Registered blocks");


        StarLoader.registerListener(ElementRegisterEvent.class, new Listener<ElementRegisterEvent>() {
            @Override
            public void onEvent(ElementRegisterEvent elementRegisterEvent) {
                elementRegisterEvent.addModuleCollection(new ManagerModuleCollection(new HeatReflectorElementManager(elementRegisterEvent.getSegmentController()), StellarLifterController.blockInfo.getId(), HeatReflector.blockInfo.getId()));
                elementRegisterEvent.addModuleCollection(new ManagerModuleCollection(new NeutroniumCapacitorElementManager(elementRegisterEvent.getSegmentController()), StellarLifterController.blockInfo.getId(), NeutroniumCapacitor.blockInfo.getId()));
                elementRegisterEvent.addModuleCollection(new ManagerModuleCollection(new GravityCompressorElementManager(elementRegisterEvent.getSegmentController()), GravityCompressorController.blockInfo.getId(), GravityCompressorModule.blockInfo.getId()));
            }
        });
    }

    public static SuperWeapons getInst() {
        return inst;
    }
}
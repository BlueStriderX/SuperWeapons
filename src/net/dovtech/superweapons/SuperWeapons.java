package net.dovtech.superweapons;

import api.DebugFile;
import api.config.BlockConfig;
import api.element.block.Blocks;
import api.element.block.FactoryType;
import api.mod.StarMod;
import net.dovtech.superweapons.blocks.systems.stellarreactor.StellarReactorController;
import net.dovtech.superweapons.blocks.weapons.StellarAcceleratorComputer;
import org.schema.game.common.data.element.ElementInformation;
import org.schema.game.common.data.element.FactoryResource;

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
        this.modVersion = "0.0.2";
        this.modDescription = "Adds powerful superweapons for you to annihilate your enemies with.";
        DebugFile.log("Enabled", this);

    }

    public void onBlockConfigLoad(BlockConfig config) {

        //Systems

        //Stellar Reactor Controller
        StellarReactorController stellarReactorController = new StellarReactorController();
        ElementInformation stellarReactorControllerInfo = stellarReactorController.getBlockInfo();
        FactoryResource[] stellarReactorControllerRecipe = {
                new FactoryResource(5000, Blocks.POWER_REACTOR.getId()),
                new FactoryResource(5000, Blocks.REACTOR_STABILIZER.getId()),
                new FactoryResource(10000, Blocks.THRENS_INGOT.getId())
        };
        BlockConfig.addRecipe(stellarReactorControllerInfo, FactoryType.ADVANCED, 30, stellarReactorControllerRecipe);
        config.add(stellarReactorControllerInfo);


        //Weapons

        //Stellar Accelerator Computer
        StellarAcceleratorComputer stellarAcceleratorComputer = new StellarAcceleratorComputer();
        ElementInformation stellarAcceleratorComputerInfo = stellarAcceleratorComputer.getBlockInfo();
        FactoryResource[] stellarAcceleratorComputerRecipe = {
                new FactoryResource(5000, Blocks.POWER_REACTOR.getId()),
                new FactoryResource(3000, Blocks.REACTOR_STABILIZER.getId()),
                new FactoryResource(500, Blocks.DAMAGE_BEAM_COMPUTER_0.getId()),
                new FactoryResource(500, Blocks.CANNON_COMPUTER.getId()),
                new FactoryResource(500, Blocks.MISSILE_COMPUTER.getId()),
                new FactoryResource(10000, Blocks.THRENS_INGOT.getId()),
        };
        BlockConfig.addRecipe(stellarAcceleratorComputerInfo, FactoryType.ADVANCED, 50, stellarAcceleratorComputerRecipe);
        config.add(stellarAcceleratorComputerInfo);
    }
}
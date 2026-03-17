package net.emilieathanas.tutorialmod.datagen;

import net.emilieathanas.tutorialmod.block.ModBlocks;
import net.emilieathanas.tutorialmod.block.custom.PinkGarnetLampBlock;
import net.emilieathanas.tutorialmod.item.ModItems;
import net.emilieathanas.tutorialmod.item.ModToolMaterials;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.util.Identifier;
import net.minecraft.client.data.VariantsBlockModelDefinitionCreator;


public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool pinkGarnetPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PINK_GARNET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);

        pinkGarnetPool.stairs(ModBlocks.PINK_GARNET_STAIRS);
        pinkGarnetPool.slab(ModBlocks.PINK_GARNET_SLAB);

        pinkGarnetPool.button(ModBlocks.PINK_GARNET_BUTTON);
        pinkGarnetPool.pressurePlate(ModBlocks.PINK_GARNET_PRESSURE_PLATE);

        pinkGarnetPool.fence(ModBlocks.PINK_GARNET_FENCE);
        pinkGarnetPool.fenceGate(ModBlocks.PINK_GARNET_FENCE_GATE);

        pinkGarnetPool.wall(ModBlocks.PINK_GARNET_WALL);
        blockStateModelGenerator.registerDoor(ModBlocks.PINK_GARNET_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.PINK_GARNET_TRAP_DOOR);


        Identifier lampOff = TexturedModel.CUBE_ALL.upload(
                ModBlocks.PINK_GARNET_LAMP,
                blockStateModelGenerator.modelCollector
        );

        Identifier lampOn = Models.CUBE_ALL.upload(
                ModelIds.getBlockSubModelId(ModBlocks.PINK_GARNET_LAMP, "_on"),
                TextureMap.all(TextureMap.getSubId(ModBlocks.PINK_GARNET_LAMP, "_on")),
                blockStateModelGenerator.modelCollector
        );

        blockStateModelGenerator.blockStateCollector.accept(
                VariantsBlockModelDefinitionCreator.of(ModBlocks.PINK_GARNET_LAMP)
                        .with(
                                BlockStateVariantMap.models(PinkGarnetLampBlock.CLICKED, PinkGarnetLampBlock.LIT)
                                        .register(true, true, BlockStateModelGenerator.createWeightedVariant(lampOff))
                                        .register(false, true, BlockStateModelGenerator.createWeightedVariant(lampOn))
                                        .register(true, false, BlockStateModelGenerator.createWeightedVariant(lampOn))
                                        .register(false, false, BlockStateModelGenerator.createWeightedVariant(lampOff))

                        )
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAULIFLOWER, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.STARLIGHT_ASHES, Models.GENERATED);

        itemModelGenerator.register(ModItems.PINK_GARNET_SWORD, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINK_GARNET_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINK_GARNET_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINK_GARNET_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINK_GARNET_HOE, Models.GENERATED);



    }
}

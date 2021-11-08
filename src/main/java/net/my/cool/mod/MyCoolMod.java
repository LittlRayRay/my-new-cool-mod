package net.my.cool.mod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MyCoolMod implements ModInitializer {

    public static final Item FABRIC_ITEM = new FabricItem(new Item.Settings().group(MyCoolMod.ITEM_GROUP));

    public static final Block DANISQUAREPANTS = new Block(FabricBlockSettings.of(Material.METAL).hardness(1.5f).resistance(7.0f));

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
        new Identifier("coolmod", "general"),
        () -> new ItemStack(Blocks.COBBLED_DEEPSLATE));
    
    public static final ItemGroup OTHER_GROUP = FabricItemGroupBuilder.create(
        new Identifier("coolmod", "other"))
        .icon(() -> new ItemStack(Items.NAME_TAG))
        .appendItems(stacks -> {
            stacks.add(new ItemStack(Blocks.BLACK_CANDLE));
            stacks.add(new ItemStack(Items.CAKE));
            stacks.add(ItemStack.EMPTY);
            stacks.add(new ItemStack(FABRIC_ITEM));

        })
        .build();
    

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("coolmod", "fabric_item"), FABRIC_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("coolmod", "danisquarepants"), DANISQUAREPANTS);
        Registry.register(Registry.ITEM, new Identifier("coolmod", "danisquarepants"), new BlockItem(DANISQUAREPANTS, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

    }
}
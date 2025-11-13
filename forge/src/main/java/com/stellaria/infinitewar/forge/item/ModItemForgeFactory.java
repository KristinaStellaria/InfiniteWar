package com.stellaria.infinitewar.forge.item;

import com.stellaria.infinitewar.InfiniteWar;
import com.stellaria.infinitewar.definition.BlockDefinition;
import com.stellaria.infinitewar.definition.FoodDefinition;
import com.stellaria.infinitewar.definition.ItemDefinition;
import com.stellaria.infinitewar.item.ModItemFactory;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemForgeFactory implements ModItemFactory {
    public final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, InfiniteWar.MOD_ID);
    public final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, InfiniteWar.MOD_ID);

    @Override
    public void createFood(FoodDefinition foodDefinition) {
        RegistryObject<Item> FOOD = ITEMS.register(foodDefinition.name,
                () -> new Item(new Item.Settings().food(new FoodComponent.Builder()
                        .hunger(foodDefinition.hungerRestores)
                        .saturationModifier(foodDefinition.saturation)
                        .build())));
    }

    public void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

    public void createBlock(BlockDefinition blockDefinition){
        RegistryObject<Block> block = BLOCKS.register(blockDefinition.name, () -> {
            Block.Settings settings = Block.Settings.create()
                    .mapColor(MapColor.STONE_GRAY)
                    .strength(blockDefinition.hardness, blockDefinition.resistance);

            if (blockDefinition.requiresTool) {
                settings.requiresTool();
            }

            return new Block(settings);
        });

        RegistryObject<Item> item = ITEMS.register(blockDefinition.name,
                () -> new BlockItem(block.get(), new Item.Settings()));
    }

    public void createItem(ItemDefinition itemDefinition){

    }
}

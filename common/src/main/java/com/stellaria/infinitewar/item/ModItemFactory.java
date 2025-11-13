package com.stellaria.infinitewar.item;

import com.stellaria.infinitewar.definition.BlockDefinition;
import com.stellaria.infinitewar.definition.FoodDefinition;
import com.stellaria.infinitewar.definition.ItemDefinition;

public interface ModItemFactory {
    public void createFood(FoodDefinition foodDefinition);
    public void createBlock(BlockDefinition blockDefinition);
    public void createItem(ItemDefinition itemDefinition);
}

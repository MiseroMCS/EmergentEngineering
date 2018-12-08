package com.misero.emergentengineering.items;

import com.misero.emergentengineering.EmergentEngineering;
import com.misero.emergentengineering.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {
    public ItemBase(String id){
        setUnlocalizedName(id);
        setRegistryName(EmergentEngineering.MODID, id);
        setCreativeTab(CreativeTabs.MISC); //TODO: REMOVE THIS DEBUG TAB AND REPLACE
        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        EmergentEngineering.proxy.registerItemRenderer(this, 0, "inventory");
    }
}

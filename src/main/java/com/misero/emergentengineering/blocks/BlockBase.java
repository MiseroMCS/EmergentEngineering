package com.misero.emergentengineering.blocks;

import com.misero.emergentengineering.EmergentEngineering;
import com.misero.emergentengineering.items.ModItems;
import com.misero.emergentengineering.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {

    public BlockBase(String id, Material blockMaterial) {
        super(blockMaterial);
        setUnlocalizedName(id);
        setRegistryName(EmergentEngineering.MODID, id);
        setCreativeTab(CreativeTabs.MISC); //TODO: REMOVE THIS DEBUG TAB AND REPLACE
        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        EmergentEngineering.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}

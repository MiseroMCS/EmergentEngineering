package com.misero.emergentengineering.networking;

import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

import java.io.IOException;

public class FabricatorSync implements IMessage {
    public FabricatorSync(){}

    int timeRemaining;
    ItemStack slot1, slot2, slot3;
    public FabricatorSync(int timeRemaining, ItemStack slot1, ItemStack slot2, ItemStack slot3){
        this.timeRemaining = timeRemaining;
        this.slot1 = slot1;
        this.slot2 = slot2;
        this.slot3 = slot3;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        PacketBuffer packetBuf = new PacketBuffer(buf);
        try {
            NBTTagCompound data = packetBuf.readCompoundTag();
        }catch(IOException e){
            System.out.println("Failed to sync Fabricator."); //screw you for sending a terrible packet.
            timeRemaining = 0;
            slot1 = ItemStack.EMPTY;
            slot2 = ItemStack.EMPTY;
            slot3 = ItemStack.EMPTY;
        }
    }

    @Override
    public void toBytes(ByteBuf buf) {
        NBTTagCompound data = new NBTTagCompound();
        data.setInteger("timeRemaining", timeRemaining);
        data.setTag("slot1", slot1.getTagCompound());
        data.setTag("slot2", slot2.getTagCompound());
        data.setTag("slot3", slot3.getTagCompound());
        PacketBuffer packetBuf = new PacketBuffer(buf);
        packetBuf.writeCompoundTag(data);
    }
}

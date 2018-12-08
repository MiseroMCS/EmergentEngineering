package com.misero.emergentengineering;

import com.misero.emergentengineering.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = EmergentEngineering.MODID, name = EmergentEngineering.NAME, version = EmergentEngineering.VERSION)
public class EmergentEngineering {
    //Basic mod info. Change these!
    public static final String MODID = "emergentengineering";
    public static final String NAME = "Emergent Engineering";
    public static final String VERSION = "1.0";

    @Mod.Instance
    public static EmergentEngineering instance;

    //Sets up the proxy - a way of running different code on a server or client instance of the game.
    @SidedProxy(clientSide="com.misero.emergentengineering.proxy.ClientProxy", serverSide="com.misero.emergentengineering.proxy.ServerProxy")
    public static CommonProxy proxy;

    private static Logger logger;

    // Initializes log helper.
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    //Initialization - currently just for debug.
    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}

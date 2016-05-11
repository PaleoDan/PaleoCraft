package net.ilexiconn.paleocraft;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "paleocraft", name = "PaleoCraft", version = PaleoCraft.VERSION, dependencies = "required-after:llibrary@[" + PaleoCraft.LLIBRARY_VERSION + ",)")
public class PaleoCraft {
    public static final String VERSION = "1.0.0-dev";
    public static final String LLIBRARY_VERSION = "1.3.0";

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {

    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent event) {

    }
}

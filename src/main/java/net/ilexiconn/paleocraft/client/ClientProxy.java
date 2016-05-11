package net.ilexiconn.paleocraft.client;

import net.ilexiconn.paleocraft.server.ServerProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends ServerProxy {
    @Override
    public void onPreInit() {
        super.onPreInit();

        MinecraftForge.EVENT_BUS.register(ClientEventHandler.INSTANCE);
    }

    @Override
    public void onInit() {
        super.onInit();
    }

    @Override
    public void onPostInit() {
        super.onPostInit();
    }
}

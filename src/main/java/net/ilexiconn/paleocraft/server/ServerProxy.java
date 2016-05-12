package net.ilexiconn.paleocraft.server;

import net.ilexiconn.paleocraft.PaleoCraft;
import net.ilexiconn.paleocraft.server.dinosaur.Dinosaur;
import net.minecraftforge.common.MinecraftForge;

public class ServerProxy {
    public void onPreInit() {
        MinecraftForge.EVENT_BUS.register(ServerEventHandler.INSTANCE);
    }

    public void onInit() {
        for (Dinosaur dinosaur : PaleoCraft.DINOSAUR_REGISTRY.getValues()) {
            System.out.println("Found dinosaur in registry: " + dinosaur.getName());
        }
    }

    public void onPostInit() {

    }
}

package net.ilexiconn.paleocraft.server;

import net.ilexiconn.paleocraft.PaleoCraft;
import net.ilexiconn.paleocraft.server.block.BlockHandler;
import net.ilexiconn.paleocraft.server.dinosaur.DinosaurHandler;
import net.ilexiconn.paleocraft.server.item.ItemHandler;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;

public class ServerProxy {
    public void onPreInit() {
        MinecraftForge.EVENT_BUS.register(ServerEventHandler.INSTANCE);
    }

    public void onInit() {
        ItemHandler.INSTANCE.onInit();
        BlockHandler.INSTANCE.onInit();
        DinosaurHandler.INSTANCE.onInit();

        DimensionManager.registerDimension(PaleoCraft.DIMENSION_ID, PaleoCraft.DIMENSION_TYPE);
        PaleoCraft.DINOSAUR_REGISTRY.getValues().forEach(DinosaurHandler.INSTANCE::registerDinosaurEntity);
    }

    public void onPostInit() {

    }
}

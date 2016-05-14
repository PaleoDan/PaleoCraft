package net.ilexiconn.paleocraft.server;

import net.ilexiconn.paleocraft.PaleoCraft;
import net.ilexiconn.paleocraft.server.block.BlockHandler;
import net.ilexiconn.paleocraft.server.dinosaur.DinosaurHandler;
import net.ilexiconn.paleocraft.server.item.ItemHandler;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ServerProxy {
    private int entityID;

    public void onPreInit() {
        MinecraftForge.EVENT_BUS.register(ServerEventHandler.INSTANCE);
        ItemHandler.INSTANCE.onInit();
        BlockHandler.INSTANCE.onInit();
        DinosaurHandler.INSTANCE.onInit();
        PaleoCraft.DINOSAUR_REGISTRY.forEach(dinosaur -> EntityRegistry.registerModEntity(dinosaur.getEntity(), dinosaur.getName().toLowerCase().replaceAll(" ", "_"), this.entityID++, PaleoCraft.INSTANCE, 1024, 1, true, dinosaur.getPrimaryEggColor(), dinosaur.getSecondaryEggColor()));
    }

    public void onInit() {
        DimensionManager.registerDimension(PaleoCraft.DIMENSION_ID, PaleoCraft.DIMENSION_TYPE);
    }

    public void onPostInit() {

    }
}

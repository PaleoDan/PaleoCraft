package net.ilexiconn.paleocraft;

import net.ilexiconn.paleocraft.server.ServerProxy;
import net.ilexiconn.paleocraft.server.dinosaur.Dinosaur;
import net.ilexiconn.paleocraft.server.world.PaleoWorldProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.IForgeRegistry;
import net.minecraftforge.fml.common.registry.PersistentRegistryManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = "paleocraft", name = "PaleoCraft", version = PaleoCraft.VERSION, dependencies = "required-after:llibrary@[" + PaleoCraft.LLIBRARY_VERSION + ",)")
public class PaleoCraft {
    public static final String VERSION = "1.0.0-dev";
    public static final String LLIBRARY_VERSION = "1.3.0";
    @SidedProxy(modId = "paleocraft", serverSide = "net.ilexiconn.paleocraft.server.ServerProxy", clientSide = "net.ilexiconn.paleocraft.client.ClientProxy")
    public static ServerProxy PROXY;
    @Mod.Instance("paleocraft")
    public static PaleoCraft INSTANCE;

    public static final Logger LOGGER = LogManager.getLogger("PaleoCraft");

    public static final ResourceLocation DINOSAUR_REGISTRY_NAME = new ResourceLocation("paleocraft", "dinosaur_registry");
    public static final int MIN_DINOSAUR_ID = 0;
    public static final int MAX_DINOSAUR_ID = 1023;
    public static final IForgeRegistry<Dinosaur> DINOSAUR_REGISTRY = PersistentRegistryManager.createRegistry(PaleoCraft.DINOSAUR_REGISTRY_NAME, Dinosaur.class, null, PaleoCraft.MIN_DINOSAUR_ID, PaleoCraft.MAX_DINOSAUR_ID, false, null, null, null);

    public static final int DIMENSION_ID = -541;
    public static final DimensionType DIMENSION_TYPE = DimensionType.register("PaleoCraft", "", PaleoCraft.DIMENSION_ID, PaleoWorldProvider.class, false);

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        PaleoCraft.PROXY.onPreInit();
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        PaleoCraft.PROXY.onInit();
    }

    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent event) {
        PaleoCraft.PROXY.onPostInit();
    }
}

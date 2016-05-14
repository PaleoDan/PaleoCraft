package net.ilexiconn.paleocraft.client;

import net.ilexiconn.paleocraft.PaleoCraft;
import net.ilexiconn.paleocraft.client.render.DinosaurRenderer;
import net.ilexiconn.paleocraft.server.ServerProxy;
import net.ilexiconn.paleocraft.server.item.ItemHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends ServerProxy {
    public static final Minecraft MINECRAFT = Minecraft.getMinecraft();

    @Override
    public void onPreInit() {
        super.onPreInit();

        MinecraftForge.EVENT_BUS.register(ClientEventHandler.INSTANCE);
        PaleoCraft.DINOSAUR_REGISTRY.forEach(dinosaur -> RenderingRegistry.registerEntityRenderingHandler(dinosaur.getEntity(), new DinosaurRenderer.Factory(dinosaur)));
    }

    @Override
    public void onInit() {
        super.onInit();
    }

    @Override
    public void onPostInit() {
        super.onPostInit();

        ItemHandler.INSTANCE.itemList.forEach(item -> ClientProxy.MINECRAFT.getRenderItem().getItemModelMesher().register(item, stack -> new ModelResourceLocation("paleocraft:" + item.getRegistryName().getResourcePath(), "inventory")));
    }
}

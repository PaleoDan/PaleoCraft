package net.ilexiconn.paleocraft.client.render;

import net.ilexiconn.paleocraft.client.ClientProxy;
import net.ilexiconn.paleocraft.server.entity.DinosaurEntity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Locale;

@SideOnly(Side.CLIENT)
public class DinosaurRenderer extends RenderLiving<DinosaurEntity> {
    private ResourceLocation texture;

    public DinosaurRenderer(ModelBase modelBase, float shadowSize) {
        super(ClientProxy.MINECRAFT.getRenderManager(), modelBase, shadowSize);
    }

    @Override
    protected ResourceLocation getEntityTexture(DinosaurEntity entity) {
        if (texture == null) {
            this.texture = new ResourceLocation("paleocraft", "textures/assets/entities/" + entity.getDinosaur().getName().toLowerCase(Locale.ENGLISH).replaceAll(" ", "_") + ".png");
        }
        return texture;
    }
}

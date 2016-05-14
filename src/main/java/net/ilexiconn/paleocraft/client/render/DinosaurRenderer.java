package net.ilexiconn.paleocraft.client.render;

import net.ilexiconn.paleocraft.PaleoCraft;
import net.ilexiconn.paleocraft.server.dinosaur.Dinosaur;
import net.ilexiconn.paleocraft.server.entity.DinosaurEntity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

@SideOnly(Side.CLIENT)
public class DinosaurRenderer extends RenderLiving<DinosaurEntity> {
    private Dinosaur dinosaur;
    private ResourceLocation texture;

    public DinosaurRenderer(RenderManager manager, ModelBase model, Dinosaur dinosaur) {
        super(manager, model, dinosaur.getShadowSize());
        this.dinosaur = dinosaur;
    }

    @Override
    protected ResourceLocation getEntityTexture(DinosaurEntity entity) {
        if (texture == null) {
            this.texture = new ResourceLocation("paleocraft", "textures/assets/entities/" + this.dinosaur.getName().toLowerCase(Locale.ENGLISH).replaceAll(" ", "_") + ".png");
        }
        return texture;
    }

    public static class Factory implements IRenderFactory<DinosaurEntity> {
        private Dinosaur dinosaur;
        private ModelBase model;

        public Factory(Dinosaur dinosaur) {
            this.dinosaur = dinosaur;
            try {
                Class<?> model = Class.forName("net.ilexiconn.paleocraft.client.model." + StringUtils.capitalize(dinosaur.getName()) + "Model");
                if (ModelBase.class.isAssignableFrom(model)) {
                    this.model = (ModelBase) model.newInstance();
                } else {
                    PaleoCraft.LOGGER.error("Invalid model class " + model.getName());
                }
            } catch (Exception e) {
                PaleoCraft.LOGGER.catching(e);
            }
        }

        @Override
        public Render<? super DinosaurEntity> createRenderFor(RenderManager manager) {
            return new DinosaurRenderer(manager, this.model, this.dinosaur);
        }
    }
}

package net.ilexiconn.paleocraft.server.dinosaur;

import net.ilexiconn.paleocraft.PaleoCraft;
import net.ilexiconn.paleocraft.client.render.DinosaurRenderer;
import net.ilexiconn.paleocraft.server.entity.DinosaurEntity;
import net.ilexiconn.paleocraft.server.entity.DromaeosaurusEntity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.StringUtils;

public enum DinosaurHandler {
    INSTANCE;

    public Dinosaur dromaeosaurus = Dinosaur.create("dromaeosaurus").setEntity(DromaeosaurusEntity.class);

    private int entityID;

    public void onInit() {
        GameRegistry.register(this.dromaeosaurus, new ResourceLocation("paleocraft", "dromaeosaurus"));
    }

    public void registerDinosaurEntity(Dinosaur dinosaur) {
        EntityRegistry.registerModEntity(dinosaur.getEntity(), dinosaur.getName().toLowerCase().replaceAll(" ", "_"), this.entityID++, PaleoCraft.INSTANCE, 1024, 1, true, dinosaur.getPrimaryEggColor(), dinosaur.getSecondaryEggColor());
    }

    @SideOnly(Side.CLIENT)
    public void registerDinosaurRenderer(Dinosaur dinosaur) {
        ModelBase modelBase = null;
        try {
            Class<?> model = Class.forName("net.ilexiconn.paleocraft.client.model." + StringUtils.capitalize(dinosaur.getName()) + "Model");
            if (ModelBase.class.isAssignableFrom(model)) {
                modelBase = (ModelBase) model.newInstance();
            } else {
                PaleoCraft.LOGGER.error("Invalid model class " + model.getName());
            }
        } catch (Exception e) {
            PaleoCraft.LOGGER.catching(e);
        }
        if (modelBase != null) {
            RenderingRegistry.registerEntityRenderingHandler(dinosaur.getEntity(), new DinosaurRenderer(modelBase, 1.0F));
        }
    }

    public Dinosaur getDinosaurFromEntity(DinosaurEntity entity) {
        for (Dinosaur dinosaur : PaleoCraft.DINOSAUR_REGISTRY) {
            if (dinosaur.getEntity() == entity.getClass()) {
                return dinosaur;
            }
        }
        return null;
    }

    public Dinosaur getDinosaurFromID(int id) {
        return PaleoCraft.DINOSAUR_REGISTRY.getObjectById(id);
    }

    public int getIDFromDinosaur(Dinosaur dinosaur) {
        return PaleoCraft.DINOSAUR_REGISTRY.getId(dinosaur);
    }
}

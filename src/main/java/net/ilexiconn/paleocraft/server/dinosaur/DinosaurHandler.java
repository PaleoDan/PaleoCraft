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

import java.util.Map;
import java.util.WeakHashMap;

public enum DinosaurHandler {
    INSTANCE;

    public Dinosaur dromaeosaurus = Dinosaur.create("dromaeosaurus").setEntity(DromaeosaurusEntity.class);

    private int entityID;
    private Map<Class<? extends DinosaurEntity>, Dinosaur> dinosaurMap = new WeakHashMap<>();

    public void onInit() {
        GameRegistry.register(this.dromaeosaurus, new ResourceLocation("paleocraft", "dromaeosaurus"));
    }

    public void registerDinosaurEntity(Dinosaur dinosaur) {
        Class<? extends DinosaurEntity> entity = dinosaur.getEntity();
        EntityRegistry.registerModEntity(entity, dinosaur.getName().toLowerCase().replaceAll(" ", "_"), this.entityID++, PaleoCraft.INSTANCE, 1024, 1, true, dinosaur.getPrimaryEggColor(), dinosaur.getSecondaryEggColor());
        this.dinosaurMap.put(entity, dinosaur);
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
        return dinosaurMap.get(entity.getClass());
    }

    public Dinosaur getDinosaurFromID(int id) {
        return PaleoCraft.DINOSAUR_REGISTRY.getObjectById(id);
    }

    public int getIDFromDinosaur(Dinosaur dinosaur) {
        return PaleoCraft.DINOSAUR_REGISTRY.getId(dinosaur);
    }
}

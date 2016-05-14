package net.ilexiconn.paleocraft.server.dinosaur;

import net.ilexiconn.paleocraft.PaleoCraft;
import net.ilexiconn.paleocraft.server.entity.DinosaurEntity;
import net.ilexiconn.paleocraft.server.entity.DromaeosaurusEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public enum DinosaurHandler {
    INSTANCE;

    public Dinosaur dromaeosaurus = Dinosaur.create("dromaeosaurus").setEntity(DromaeosaurusEntity.class);

    public void onInit() {
        GameRegistry.register(this.dromaeosaurus, new ResourceLocation("paleocraft", "dromaeosaurus"));
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

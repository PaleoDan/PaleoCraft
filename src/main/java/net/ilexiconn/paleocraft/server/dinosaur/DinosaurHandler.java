package net.ilexiconn.paleocraft.server.dinosaur;

import net.ilexiconn.paleocraft.PaleoCraft;
import net.ilexiconn.paleocraft.server.entity.DinosaurEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Map;
import java.util.WeakHashMap;

public enum DinosaurHandler {
    INSTANCE;

    public Dinosaur dromaeosaurus = Dinosaur.create("dromaeosaurus");

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

    public Dinosaur getDinosaurFromEntity(DinosaurEntity entity) {
        return dinosaurMap.get(entity.getClass());
    }
}

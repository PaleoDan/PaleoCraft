package net.ilexiconn.paleocraft.server.entity;

import net.ilexiconn.paleocraft.server.dinosaur.Dinosaur;
import net.ilexiconn.paleocraft.server.dinosaur.DinosaurHandler;
import net.minecraft.entity.EntityCreature;
import net.minecraft.world.World;

public class DinosaurEntity extends EntityCreature {
    private Dinosaur dinosaur;

    public DinosaurEntity(World world) {
        super(world);
        this.dinosaur = DinosaurHandler.INSTANCE.getDinosaurFromEntity(this);
    }

    public Dinosaur getDinosaur() {
        return dinosaur;
    }
}

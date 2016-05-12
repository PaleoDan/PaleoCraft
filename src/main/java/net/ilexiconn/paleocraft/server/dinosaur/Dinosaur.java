package net.ilexiconn.paleocraft.server.dinosaur;

import net.ilexiconn.paleocraft.server.dinosaur.type.BehaviourType;
import net.ilexiconn.paleocraft.server.dinosaur.type.SizeType;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.common.registry.IForgeRegistryEntry;

public class Dinosaur extends IForgeRegistryEntry.Impl<Dinosaur> {
    private String name;
    private SizeType size;
    private BehaviourType behaviour;

    public Dinosaur setName(String name) {
        this.name = name;
        return this;
    }

    public Dinosaur setSize(SizeType size) {
        this.size = size;
        return this;
    }

    public Dinosaur setBehaviour(BehaviourType behaviour) {
        this.behaviour = behaviour;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getLocalizedName() {
        return I18n.translateToLocal(this.getName());
    }

    public SizeType getSize() {
        return size;
    }

    public BehaviourType getBehaviour() {
        return behaviour;
    }
}

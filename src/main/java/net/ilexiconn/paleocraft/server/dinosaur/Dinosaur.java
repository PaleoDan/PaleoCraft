package net.ilexiconn.paleocraft.server.dinosaur;

import net.ilexiconn.paleocraft.PaleoCraft;
import net.ilexiconn.paleocraft.server.dinosaur.type.BehaviourType;
import net.ilexiconn.paleocraft.server.dinosaur.type.SizeType;
import net.ilexiconn.paleocraft.server.entity.DinosaurEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.common.registry.IForgeRegistryEntry;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Consumer;

public final class Dinosaur extends IForgeRegistryEntry.Impl<Dinosaur> {
    private String name;
    private SizeType size;
    private BehaviourType behaviour;
    private Class<? extends DinosaurEntity> entity;
    private int primaryEggColor;
    private int secondaryEggColor;
    private Consumer<NBTTagCompound> nbtWriter;
    private Consumer<NBTTagCompound> nbtReader;
    private float shadowSize;

    private Dinosaur() {
    }

    public static Dinosaur create(String name) {
        return Dinosaur.create(name, false);
    }

    public static Dinosaur create(String name, boolean customEntity) {
        Dinosaur dinosaur = new Dinosaur();
        dinosaur.name = name;
        if (customEntity) {
            try {
                Class<?> entity = Class.forName("net.ilexiconn.paleocraft.server.entity." + StringUtils.capitalize(name) + "Entity");
                if (DinosaurEntity.class.isAssignableFrom(entity)) {
                    dinosaur.entity = (Class<? extends DinosaurEntity>) entity;
                } else {
                    PaleoCraft.LOGGER.error("Invalid entity class " + entity.getName());
                }
            } catch (ClassNotFoundException e) {
                PaleoCraft.LOGGER.catching(e);
            }
        }
        return dinosaur;
    }

    public Dinosaur setSize(SizeType size) {
        this.size = size;
        return this;
    }

    public Dinosaur setBehaviour(BehaviourType behaviour) {
        this.behaviour = behaviour;
        return this;
    }

    public Dinosaur setEntity(Class<? extends DinosaurEntity> entity) {
        this.entity = entity;
        return this;
    }

    public Dinosaur setEggColor(int primaryEggColor, int secondaryEggColor) {
        this.primaryEggColor = primaryEggColor;
        this.secondaryEggColor = secondaryEggColor;
        return this;
    }

    public Dinosaur setNBTReader(Consumer<NBTTagCompound> nbtReader) {
        this.nbtReader = nbtReader;
        return this;
    }

    public Dinosaur setNBTWriter(Consumer<NBTTagCompound> nbtWriter) {
        this.nbtWriter = nbtWriter;
        return this;
    }

    public Dinosaur setshadowSize(float shadowSize) {
        this.shadowSize = shadowSize;
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

    public Class<? extends DinosaurEntity> getEntity() {
        return entity;
    }

    public int getPrimaryEggColor() {
        return primaryEggColor;
    }

    public int getSecondaryEggColor() {
        return secondaryEggColor;
    }

    public void readNBT(NBTTagCompound compound) {
        if (this.nbtReader != null) {
            this.nbtReader.accept(compound);
        }
    }

    public void writeNBT(NBTTagCompound compound) {
        if (this.nbtWriter != null) {
            this.nbtWriter.accept(compound);
        }
    }

    public float getShadowSize() {
        return shadowSize;
    }
}

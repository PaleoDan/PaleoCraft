package net.ilexiconn.paleocraft.server.world;

import net.ilexiconn.paleocraft.PaleoCraft;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;

public class PaleoWorldProvider extends WorldProvider {
    @Override
    public DimensionType getDimensionType() {
        return PaleoCraft.DIMENSION_TYPE;
    }
}

package net.ilexiconn.paleocraft.server.block;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public enum BlockHandler {
    INSTANCE;

    public Block portal;

    public void onInit() {
        GameRegistry.register(this.portal = new PaleoPortalBlock(), new ResourceLocation("paleocraft", "portal"));
    }
}

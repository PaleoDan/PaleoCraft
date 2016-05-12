package net.ilexiconn.paleocraft.server.block;

import net.ilexiconn.paleocraft.server.item.ItemHandler;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

public enum BlockHandler {
    INSTANCE;

    public Block portal = new PaleoPortalBlock();

    public List<Block> blockList = new ArrayList<>();

    public void onInit() {
        this.registerBlock(this.portal, "portal");
    }

    public void registerBlock(Block block, String name) {
        GameRegistry.register(block, new ResourceLocation("paleocraft", name));
        this.blockList.add(block);
        ItemHandler.INSTANCE.registerItem(new ItemBlock(block), name);
    }
}

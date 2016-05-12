package net.ilexiconn.paleocraft.server.item;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

public enum ItemHandler {
    INSTANCE;

    public List<Item> itemList = new ArrayList<>();

    public void onInit() {

    }

    public void registerItem(Item item, String name) {
        GameRegistry.register(item, new ResourceLocation("paleocraft", name));
        this.itemList.add(item);
    }
}

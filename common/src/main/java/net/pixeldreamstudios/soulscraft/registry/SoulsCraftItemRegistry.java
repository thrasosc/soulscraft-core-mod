package net.pixeldreamstudios.soulscraft.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.pixeldreamstudios.soulscraft.SoulsCraft;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SoulsCraftItemRegistry {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(SoulsCraft.MOD_ID, Registries.ITEM);
    private static final Map<String, RegistrySupplier<Item>> REGISTERED_ITEMS = new HashMap<>();

    public static void init() {
        ITEMS.register();
    }

    public static RegistrySupplier<Item> registerItem(String modId, String name, Supplier<Item> itemSupplier) {
        String fullName = modId + ":" + name;
        if (REGISTERED_ITEMS.containsKey(fullName)) {
            throw new IllegalArgumentException("Item " + fullName + " is already registered!");
        }

        RegistrySupplier<Item> item = ITEMS.register(name, itemSupplier);
        REGISTERED_ITEMS.put(fullName, item);
        return item;
    }

    public static RegistrySupplier<Item> getItem(String modId, String name) {
        return REGISTERED_ITEMS.get(modId + ":" + name);
    }
}

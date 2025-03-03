package pl.kaxtusik.meteor.model;

import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Reward {
    private final ItemStack itemStack;
    private final List<String> commands;
    private final double chance;
    private final String displayName;

    public Reward(ItemStack itemStack, List<String> commands, double chance, String displayName) {
        this.itemStack = itemStack;
        this.commands = commands;
        this.chance = chance;
        this.displayName = displayName;
    }

    public double getChance() {
        return chance;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public List<String> getCommands() {
        return commands;
    }

    public String getDisplayName() {
        return displayName;
    }
}

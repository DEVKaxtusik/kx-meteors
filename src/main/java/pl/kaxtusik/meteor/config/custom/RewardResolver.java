package pl.kaxtusik.meteor.config.custom;

import eu.okaeri.configs.schema.GenericsDeclaration;
import eu.okaeri.configs.serdes.DeserializationData;
import eu.okaeri.configs.serdes.ObjectSerializer;
import eu.okaeri.configs.serdes.SerializationData;
import org.bukkit.inventory.ItemStack;
import pl.kaxtusik.meteor.model.Reward;

public class RewardResolver implements ObjectSerializer<Reward> {
    @Override
    public boolean supports(Class<? super Reward> type) {
        return Reward.class.isAssignableFrom(type);
    }

    @Override
    public void serialize(Reward object, SerializationData data, GenericsDeclaration generics) {
        data.add("item",object.getItemStack());
        data.add("commands",object.getCommands());
        data.add("chance",object.getChance());
        data.add("displayName",object.getDisplayName());
    }

    @Override
    public Reward deserialize(DeserializationData data, GenericsDeclaration generics) {
        return new Reward(data.get("item", ItemStack.class),data.getAsList("commands", String.class),data.get("chance", Double.class),data.get("displayName", String.class));
    }
}

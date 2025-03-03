package pl.kaxtusik.meteor.module.provider;

import com.google.inject.Inject;
import com.google.inject.Provider;
import eu.okaeri.configs.ConfigManager;
import eu.okaeri.configs.yaml.bukkit.YamlBukkitConfigurer;
import eu.okaeri.configs.yaml.bukkit.serdes.SerdesBukkit;
import pl.kaxtusik.meteor.Plugin;
import pl.kaxtusik.meteor.config.Rewards;
import pl.kaxtusik.meteor.config.custom.RewardResolver;

import java.io.File;

public class RewardsProvider implements Provider<Rewards> {

    private final Plugin plugin;

    @Inject
    public RewardsProvider(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public Rewards get() {
        return ConfigManager.create(Rewards.class, (it) -> {
            it.withConfigurer(new YamlBukkitConfigurer(), new SerdesBukkit());
            it.withSerdesPack(registry -> registry.register(new RewardResolver()));
            it.withBindFile(new File(plugin.getDataFolder(), "storage.yml"));
            it.withRemoveOrphans(true);
            it.saveDefaults();
            it.load(true);
        });
    }
}

package pl.kaxtusik.meteor.module.provider;

import com.google.inject.Inject;
import com.google.inject.Provider;
import eu.okaeri.configs.ConfigManager;
import eu.okaeri.configs.yaml.bukkit.YamlBukkitConfigurer;
import eu.okaeri.configs.yaml.bukkit.serdes.SerdesBukkit;
import pl.kaxtusik.meteor.Plugin;
import pl.kaxtusik.meteor.config.Config;

import java.io.File;

public class ConfigProvider implements Provider<Config> {

    private final Plugin plugin;

    @Inject
    public ConfigProvider(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public Config get() {
        return ConfigManager.create(Config.class, (it) -> {
            it.withConfigurer(new YamlBukkitConfigurer(), new SerdesBukkit());
            it.withBindFile(new File(plugin.getDataFolder(), "config.yml"));
            it.withRemoveOrphans(true);
            it.saveDefaults();
            it.load(true);
        });
    }
}
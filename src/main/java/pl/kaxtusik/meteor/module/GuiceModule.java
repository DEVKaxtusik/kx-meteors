package pl.kaxtusik.meteor.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import pl.kaxtusik.meteor.Plugin;
import pl.kaxtusik.meteor.config.Config;
import pl.kaxtusik.meteor.config.Rewards;
import pl.kaxtusik.meteor.module.provider.ConfigProvider;
import pl.kaxtusik.meteor.module.provider.RewardsProvider;

public class GuiceModule extends AbstractModule {

    private final Plugin plugin;

    public GuiceModule(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    protected void configure() {
        bind(Plugin.class).toInstance(plugin);
        bind(Config.class).toProvider(ConfigProvider.class).in(Singleton.class);
        bind(Rewards.class).toProvider(RewardsProvider.class).in(Singleton.class);
    }
}
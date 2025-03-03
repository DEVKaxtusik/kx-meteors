package pl.kaxtusik.meteor;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.tcoded.folialib.FoliaLib;
import dev.rollczi.litecommands.LiteCommands;
import dev.rollczi.litecommands.bukkit.LiteBukkitFactory;
import net.byteflux.libby.BukkitLibraryManager;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import pl.kaxtusik.meteor.command.MeteorCommand;
import pl.kaxtusik.meteor.command.helper.PermissionHelper;
import pl.kaxtusik.meteor.manager.RewardManager;
import pl.kaxtusik.meteor.module.GuiceModule;

public final class Plugin extends JavaPlugin {

    public static Plugin INSTANCE;
    private FoliaLib foliaLib;
    private Injector injector;
    private RewardManager rewardManager;
    private LiteCommands<CommandSender> liteCommands;

    @Override
    public void onLoad() {
        INSTANCE = this;
        BukkitLibraryManager libraryManager = new BukkitLibraryManager(this, "libraries");
    }

    @Override
    public void onEnable() {
        foliaLib = new FoliaLib(this);
        setupInject();
        loadManager();
        loadCommands();
    }

    private void setupInject() {
        injector = Guice.createInjector(new GuiceModule(this));
    }

    private void loadManager() {
        rewardManager = injector.getInstance(RewardManager.class);
    }

    private void loadCommands() {
        liteCommands = LiteBukkitFactory.builder("kx",this)
                .commands(new MeteorCommand())
                .missingPermission(new PermissionHelper())
                .build();
    }

    public FoliaLib getFoliaLib() {
        return foliaLib;
    }

    @Override
    public void onDisable() {
        if (liteCommands != null) {
            liteCommands.unregister();
        }
    }
}

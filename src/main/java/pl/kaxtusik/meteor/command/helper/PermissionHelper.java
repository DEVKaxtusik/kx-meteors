package pl.kaxtusik.meteor.command.helper;

import com.google.inject.Inject;
import dev.rollczi.litecommands.handler.result.ResultHandlerChain;
import dev.rollczi.litecommands.invocation.Invocation;
import dev.rollczi.litecommands.permission.MissingPermissions;
import dev.rollczi.litecommands.permission.MissingPermissionsHandler;
import org.bukkit.command.CommandSender;
import pl.kaxtusik.meteor.config.Config;
import pl.kaxtusik.meteor.util.ColorUtils;

public class PermissionHelper implements MissingPermissionsHandler<CommandSender> {

    private final Config config;

    @Inject
    public PermissionHelper(Config config) {
        this.config = config;
    }

    @Override
    public void handle(Invocation<CommandSender> invocation, MissingPermissions missingPermissions, ResultHandlerChain<CommandSender> chain) {
        final CommandSender sender = invocation.sender();
        sender.sendMessage(ColorUtils.formatToComponent(config.noPermissionMessage));
        return;
    }

}

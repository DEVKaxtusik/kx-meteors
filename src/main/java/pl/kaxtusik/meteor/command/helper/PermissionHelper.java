package pl.kaxtusik.meteor.command.helper;

import dev.rollczi.litecommands.handler.result.ResultHandlerChain;
import dev.rollczi.litecommands.invocation.Invocation;
import dev.rollczi.litecommands.permission.MissingPermissions;
import dev.rollczi.litecommands.permission.MissingPermissionsHandler;
import org.bukkit.command.CommandSender;
import pl.kaxtusik.meteor.util.ColorUtils;

public class PermissionHelper implements MissingPermissionsHandler<CommandSender> {

    @Override
    public void handle(Invocation<CommandSender> invocation, MissingPermissions missingPermissions, ResultHandlerChain<CommandSender> chain) {
        final CommandSender sender = invocation.sender();
        sender.sendMessage(ColorUtils.formatToComponent("&4❌ &fNie masz uprawnień do użycia tej komendy!"));
        return;
    }

}

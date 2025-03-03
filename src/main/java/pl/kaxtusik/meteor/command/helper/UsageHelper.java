package pl.kaxtusik.meteor.command.helper;

import dev.rollczi.litecommands.handler.result.ResultHandlerChain;
import dev.rollczi.litecommands.invalidusage.InvalidUsage;
import dev.rollczi.litecommands.invalidusage.InvalidUsageHandler;
import dev.rollczi.litecommands.invocation.Invocation;
import org.bukkit.command.CommandSender;
import pl.kaxtusik.meteor.util.ColorUtils;

public class UsageHelper implements InvalidUsageHandler<CommandSender> {
    @Override
    public void handle(Invocation<CommandSender> invocation, InvalidUsage<CommandSender> result, ResultHandlerChain<CommandSender> chain) {
        final CommandSender sender = invocation.sender();

    }
}

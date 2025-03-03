package pl.kaxtusik.meteor.command;

import com.google.inject.Inject;
import dev.rollczi.litecommands.annotations.argument.Arg;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.optional.OptionalArg;
import dev.rollczi.litecommands.annotations.permission.Permission;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import pl.kaxtusik.meteor.config.Config;
import pl.kaxtusik.meteor.config.Rewards;
import pl.kaxtusik.meteor.context.ContextEnums;
import pl.kaxtusik.meteor.model.Reward;
import pl.kaxtusik.meteor.util.ColorUtils;

import java.util.Optional;

@Command(name = "meteor")
@Permission("kx.meteor.admin")
public class MeteorCommand {

    private final Config config;

    private final Rewards storage;

    @Inject
    public MeteorCommand(Config config, Rewards storage) {
        this.config = config;
        this.storage = storage;
    }


    @Execute(name = "reward")
    void reward(@Context CommandSender sender, @Arg ContextEnums.RewardEnums context, @Arg Optional<Reward> reward) {
        switch (context) {
            case ADD -> {
                if (sender instanceof ConsoleCommandSender) {
                    sender.sendMessage(ColorUtils.formatToComponent("&cYou can't invoke this in console!"));
                    break;
                }
                break;
            }
            case EDIT -> {
                if (sender instanceof ConsoleCommandSender) {
                    sender.sendMessage(ColorUtils.formatToComponent("&cYou can't invoke this in console!"));
                    break;
                }

                break;
            }
            case REMOVE -> {
                if (reward.isEmpty()) {

                }
                break;
            }
        }
    }

}

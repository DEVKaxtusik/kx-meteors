package pl.kaxtusik.meteor.command.custom;

import com.google.inject.Inject;
import dev.rollczi.litecommands.argument.Argument;
import dev.rollczi.litecommands.argument.parser.ParseResult;
import dev.rollczi.litecommands.argument.resolver.ArgumentResolver;
import dev.rollczi.litecommands.invocation.Invocation;
import dev.rollczi.litecommands.suggestion.SuggestionContext;
import dev.rollczi.litecommands.suggestion.SuggestionResult;
import org.bukkit.command.CommandSender;
import pl.kaxtusik.meteor.manager.RewardManager;
import pl.kaxtusik.meteor.model.Reward;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RewardResolver extends ArgumentResolver<CommandSender, Reward> {

    private final RewardManager rewardManager;
    private final Map<String, Reward> rewardMap = new ConcurrentHashMap<>();

    @Inject
    public RewardResolver(RewardManager rewardManager) {
        this.rewardManager = rewardManager;
    }

    @Override
    protected ParseResult<Reward> parse(Invocation<CommandSender> invocation, Argument<Reward> context, String argument) {

    }

    @Override
    public SuggestionResult suggest(Invocation<CommandSender> invocation, Argument<Reward> argument, SuggestionContext context) {
        return super.suggest(invocation, argument, context);
    }

}

package pl.kaxtusik.meteor.manager;

import com.google.inject.Inject;
import pl.kaxtusik.meteor.config.Rewards;
import pl.kaxtusik.meteor.model.Reward;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RewardManager {
    private final Map<String, Reward> rewards = new ConcurrentHashMap<>();

    @Inject
    public RewardManager(Rewards storage) {
        loadRewards(storage);
    }

    private void loadRewards(Rewards storage) {
        rewards.clear();
        for (Reward r : storage.rewards) {
            rewards.put(r.getDisplayName(), r);
        }
    }

    public Reward getReward(String name) {
        return rewards.get(name);
    }

    public Map<String, Reward> getRewards() {
        return Collections.unmodifiableMap(rewards);
    }
}

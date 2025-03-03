package pl.kaxtusik.meteor.manager;

import com.google.inject.Inject;
import pl.kaxtusik.meteor.config.Rewards;
import pl.kaxtusik.meteor.model.Reward;

import java.util.ArrayList;
import java.util.List;

public class RewardManager {
    private List<Reward> rewards = new ArrayList<>();
    private Rewards storage;

    @Inject
    public RewardManager(Rewards rewards) {
        this.storage = rewards;
    }

    public void loadRewards() {
        rewards.addAll(storage.rewards);
    }


}

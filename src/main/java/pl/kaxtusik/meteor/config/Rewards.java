package pl.kaxtusik.meteor.config;

import eu.okaeri.configs.OkaeriConfig;
import pl.kaxtusik.meteor.model.Reward;

import java.util.ArrayList;
import java.util.List;

public class Rewards extends OkaeriConfig {
    public List<Reward> rewards = new ArrayList<>();
}

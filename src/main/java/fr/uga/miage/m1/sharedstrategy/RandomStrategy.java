package fr.uga.miage.m1.sharedstrategy;

import java.util.Random;

class RandomStrategy implements IStrategy {
    private static final double OPPOSITE_CHOICE_DEFAULT_PROBABILITY = 0.1;

    protected static final Random RANDOM = new Random();

    public final StrategyChoice chooseRandomly(StrategyChoice defaultChoice, double oppositeChoiceProbability) {
        StrategyChoice oppositeChoice = defaultChoice.getOpposite();
        if (oppositeChoiceProbability < 0.0 || oppositeChoiceProbability > 1.0) {
            oppositeChoiceProbability = OPPOSITE_CHOICE_DEFAULT_PROBABILITY;
        }
        if (RANDOM.nextDouble() < oppositeChoiceProbability) {
            return oppositeChoice;
        }
        return defaultChoice;
    }

    public final StrategyChoice chooseRandomly(StrategyChoice defaultChoice) {
        return chooseRandomly(defaultChoice, OPPOSITE_CHOICE_DEFAULT_PROBABILITY);
    }

    @Override
    public String getUniqueId() {
        return "RANDOM";
    }

    @Override
    public String getFullName() {
        return "Aléatoire";
    }

    @Override
    public StrategyChoice execute(StrategyExecutionData data) {
        return chooseRandomly(StrategyChoice.COOPERATE, 0.5);
    }
}

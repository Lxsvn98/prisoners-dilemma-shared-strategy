package fr.uga.miage.m1.sharedstrategy;

public final class CooperateStrategy implements IStrategy {
    @Override
    public String getUniqueId() {
        return "COOPERATE";
    }

    @Override
    public String getFullName() {
        return "Toujours coopérer";
    }

    @Override
    public StrategyChoice execute(StrategyExecutionData strategyExecutionData) {
        return StrategyChoice.COOPERATE;
    }
}

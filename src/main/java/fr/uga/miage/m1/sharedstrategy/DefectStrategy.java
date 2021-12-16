package fr.uga.miage.m1.sharedstrategy;

public final class DefectStrategy implements IStrategy {
    @Override
    public String getUniqueId() {
        return "DEFECT";
    }

    @Override
    public String getFullName() {
        return "Toujours trahir";
    }

    @Override
    public StrategyChoice execute(StrategyExecutionData strategyExecutionData) {
        return StrategyChoice.DEFECT;
    }
}

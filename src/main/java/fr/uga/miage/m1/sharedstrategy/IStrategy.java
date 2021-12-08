package fr.uga.miage.m1.sharedstrategy;

public interface IStrategy {
    String getUniqueId();

    String getFullName();

    StrategyChoice execute(StrategyExecutionData executionData);
}

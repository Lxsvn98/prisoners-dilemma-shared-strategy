package fr.uga.miage.m1.sharedstrategy;

public enum StrategyChoice {
    DEFECT,
    COOPERATE,
    NONE;

    public final StrategyChoice getOpposite() {
        if (this == NONE) {
            return NONE;
        }
        return this == COOPERATE ? DEFECT : COOPERATE;
    }

    public final boolean isDefect() {
        return this == DEFECT;
    }

    public final boolean isCooperate() {
        return this == COOPERATE;
    }

    public final boolean isNone() {
        return this == NONE;
    }

    public final boolean is(StrategyChoice choice) {
        return this == choice;
    }
}

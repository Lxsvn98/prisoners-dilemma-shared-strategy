package fr.uga.miage.m1.sharedstrategy;

import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;

public class StrategyExecutionData {
    private int gameCurrentTurnCount;
    private final int[] mainPlayerScores = new int[2];
    private final int[] opposingPlayerScores = new int[2];
    private Deque<StrategyChoice> mainPlayerChoicesHistory;
    private Deque<StrategyChoice> opposingPlayerChoicesHistory;

    public int getGameCurrentTurnCount() {
        return gameCurrentTurnCount;
    }

    public StrategyExecutionData setGameCurrentTurnCount(int gameCurrentTurnCount) {
        this.gameCurrentTurnCount = gameCurrentTurnCount;
        return this;
    }

    public Deque<StrategyChoice> getMainPlayerChoicesHistory() {
        return mainPlayerChoicesHistory;
    }

    public StrategyExecutionData setMainPlayerChoicesHistory(Deque<StrategyChoice> mainPlayerChoicesHistory) {
        this.mainPlayerChoicesHistory = mainPlayerChoicesHistory;
        return this;
    }

    public Deque<StrategyChoice> getOpposingPlayerChoicesHistory() {
        return opposingPlayerChoicesHistory;
    }

    public StrategyExecutionData setOpposingPlayerChoicesHistory(Deque<StrategyChoice> opposingPlayerChoicesHistory) {
        this.opposingPlayerChoicesHistory = opposingPlayerChoicesHistory;
        return this;
    }

    public int getMainPlayerScore() {
        return mainPlayerScores[0];
    }

    public StrategyExecutionData setMainPlayerScore(int mainPlayerScore) {
        mainPlayerScores[0] = mainPlayerScore;
        return this;
    }

    public int getMainPlayerPreviousScore() {
        return mainPlayerScores[1];
    }

    public StrategyExecutionData setMainPlayerPreviousScore(int mainPlayerPreviousScore) {
        mainPlayerScores[1] = mainPlayerPreviousScore;
        return this;
    }

    public int getOpposingPlayerScore() {
        return opposingPlayerScores[0];
    }

    public StrategyExecutionData setOpposingPlayerScore(int opposingPlayerScore) {
        opposingPlayerScores[0] = opposingPlayerScore;
        return this;
    }

    public int getOpposingPlayerPreviousScore() {
        return opposingPlayerScores[1];
    }

    public StrategyExecutionData setOpposingPlayerPreviousScore(int opposingPlayerPreviousScore) {
        opposingPlayerScores[1] = opposingPlayerPreviousScore;
        return this;
    }

    private StrategyChoice getPlayerLastChoice(boolean isMainPlayer) {
        try {
            if (isMainPlayer) {
                return mainPlayerChoicesHistory.getLast();
            } else {
                return opposingPlayerChoicesHistory.getLast();
            }
        } catch (NoSuchElementException e){
            return StrategyChoice.NONE;
        }
    }

    private StrategyChoice getMainPlayerLastChoice() {
        return getPlayerLastChoice(true);
    }

    private StrategyChoice getOpposingPlayerLastChoice() {
        return getPlayerLastChoice(false);
    }

    public boolean hasMainPlayerDefectedLastTurn() {
        return getMainPlayerLastChoice().isDefect();
    }

    public boolean hasMainPlayerCooperatedLastTurn() {
        return getMainPlayerLastChoice().isCooperate();
    }

    public boolean hasOpposingPlayerDefectedLastTurn() {
        return getOpposingPlayerLastChoice().isDefect();
    }

    public boolean hasOpposingPlayerCooperatedLastTurn() {
        return getOpposingPlayerLastChoice().isCooperate();
    }

    private int getPlayerChoiceCount(StrategyChoice strategyChoice, boolean isMainPlayer) {
        BiFunction<Integer, StrategyChoice, Integer> countChoiceReducer =
                (counter, choice) -> counter + (choice == strategyChoice ? 1 : 0);
        Deque<StrategyChoice> choicesHistory = isMainPlayer ? mainPlayerChoicesHistory : opposingPlayerChoicesHistory;
        return choicesHistory.stream().reduce(0, countChoiceReducer, Integer::sum);
    }

    public int getMainPlayerChoiceCount(StrategyChoice choice) {
        return getPlayerChoiceCount(choice, true);
    }

    public int getOpposingPlayerChoiceCount(StrategyChoice choice) {
        return getPlayerChoiceCount(choice, false);
    }
}

package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Frame {

    private static final int MAX_PINS_COUNT = 10;
    private List<Roll> rolls = new ArrayList<Roll>();
    private int score = 0;
    private boolean strike = false;
    private boolean spare = false;

    Frame() {

    }

    public void addScore(int score) {
        this.score += score;
    }

    public List<Roll> roll(boolean isLastFrame) {

        while (rolls.size() < 2 || this.winThirdRoll(isLastFrame)) {
            int availablePins = this.getAvailablePins();
            int pinsCount = (new Random()).nextInt(availablePins);
            Roll roll = new Roll(pinsCount);
            this.rolls.add(roll);
        }

        if (rolls.get(0).getPinsCount() == 10) {
            this.setStrike(true);
        } else if (rolls.size() == 2 && rolls.get(0).getPinsCount() + rolls.get(1).getPinsCount() == 10) {
            this.setSpare(true);
        }

        return this.getRolls();
    }

    private int getAvailablePins() {
        int availablePins;
        if (this.rolls.size() == 0) {
            availablePins = MAX_PINS_COUNT;
        } else {
            availablePins = MAX_PINS_COUNT - this.rolls.get(0).getPinsCount();
        }

        return availablePins;
    }

    private boolean winThirdRoll(boolean isLastFrame) {
        int pinCount;
        //for (rolls.iterator().next()) TODO
        return isLastFrame && rolls.size() == 2 && rolls.get(0).getPinsCount() + rolls.get(1).getPinsCount() == 10;
    }

    public void calculateScore(int pinsCount) {
        //TODO
        this.addScore(pinsCount);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Roll> getRolls() {
        return rolls;
    }

    public boolean isStrike() {
        return strike;
    }

    public boolean isSpare() {
        return spare;
    }

    public void setStrike(boolean strike) {
        this.strike = strike;
    }

    public void setSpare(boolean spare) {
        this.spare = spare;
    }
}

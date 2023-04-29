package org.example.darkshire.common.model;

import org.example.darkshire.api.model.Dice;

import java.util.Random;

public class SixSidedDice implements Dice {
    
    private final Random random = new Random();
    
    @Override
    public int roll() {
        return random.nextInt(6) + 1;
    }
}

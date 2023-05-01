package org.example.darkshire.common.model;

import org.example.darkshire.api.model.Dice;

import java.util.Random;

public class SixSidedDice implements Dice {
    
    private static final Random RANDOM = new Random();
    
    @Override
    public int roll() {
        return RANDOM.nextInt(6) + 1;
    }
}

package com.theironyard.charlotte;

/**
 * Created by Ben on 1/25/17.
 */
public class Guess {
    private String name;
    private int guess;

    public Guess(String name, int guess) {
        this.name = name;
        this.guess = guess;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }
}

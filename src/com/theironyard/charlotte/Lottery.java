package com.theironyard.charlotte;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Ben on 1/25/17.
 */
public class Lottery {
    private List<Guess> guesses;

    Lottery() {
        guesses = new ArrayList<>();
    }

    public void guess(String name, int number) {
        if (number < 1 || number > 25) {
            throw new IllegalArgumentException("This number must be between 1 and 25.");
        }

        guesses.add(new Guess(name, number));
    }

    public void pick() {
        // generates a random number 1-25
        int randomNumber = (int)(Math.random() * 25) + 1;

        // scans the list of entries
        // if someone's guess has that number, then
        List<Guess> winners =
            guesses.stream()
                   .filter(g -> g.getGuess() == randomNumber)
                   .collect(Collectors.toList());

        if (winners.size() == 0) {
            System.out.println("No winners this time!");
        } else {
            // print %s wins the bacon!
            winners.forEach(w -> System.out.printf("%s wins the bacon!\n", w.getName()));
        }
    }

    public void playLottery() {
        // run the lottery 25 times
        for (int i = 0;i < 25;i++) {
            pick();
        }
    }
}

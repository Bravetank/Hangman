package com.bravetank;

import java.util.Scanner;

public class Prompter {
    private Game game;

    public Prompter (Game game){
        this.game = game;
    }

    public boolean promptForGuess(){
        boolean isHit = false;
        Scanner input = new Scanner(System.in);
        boolean isAcceptable = false;

        do {
            System.out.println("Enter a letter: ");
            String guessInput = input.nextLine();

            try {
                isHit = game.applyGuess(guessInput);
                isAcceptable = true;
            } catch (IllegalArgumentException iae) {
                System.out.printf("%s Please try again %n", iae.getMessage());
            }
        } while (! isAcceptable);
        return isHit;
    }

    public void displayProgress(){
        System.out.printf("You have %d tries remaining. Try to solve %s%n",
                game.getRemainingTries(),
                game.getCurrentProgress());
    }

    public void displayOutcome() {
        if (game.getRemainingTries() == 0){
            System.out.println("Sorry game over. The word was " + game.getAnswer());
        } else {
            System.out.printf("Yay you guessed it with %d tries remaining!",
                    game.getRemainingTries());
        }
    }
}

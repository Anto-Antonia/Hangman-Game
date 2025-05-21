package org.example;

import java.util.Locale;
import java.util.Scanner;

public class HangmanGame {
   private String wordToGuess;
   private char[] guessWord;
   private int tries;
   private int maxTries;
   private String guessedLetters;

    public HangmanGame(String wordToGuess) {
        this.wordToGuess = wordToGuess;
        this.guessWord = new char[wordToGuess.length()];
        this.tries = 0;
        this.maxTries = 8;
        this.guessedLetters = "";

        for(int i = 0; i<guessWord.length; i++){
            guessWord[i] = '_';
        }
    }

    public void play(){
        Scanner scanner = new Scanner(System.in);
        boolean wordGuessed = false;

        System.out.println("Welcome to the hangman game!");

        while(tries < maxTries && !wordGuessed){
            displayedWord();
            System.out.println("Guess a letter: ");
            String input = scanner.nextLine().toLowerCase();

            if(input.length() != 1 || !Character.isLetter(input.charAt(0))){
                System.out.println("Please enter a single valid letter.");
                continue;
            }

            char guessedChar = input.charAt(0);

            if(guessedLetters.contains(String.valueOf(guessedChar))){
                System.out.println("You already guessed that letter.");
                continue;
            }

            guessedLetters += guessedChar;

            boolean correct = false;
            for(int i = 0; i < wordToGuess.length(); i++){
                if(wordToGuess.charAt(i)==guessedChar){
                    guessWord[i] = guessedChar;
                    correct = true;
                }
            }

            if(!correct){
                tries++;
                System.out.println("Wrong! Tries left: " + (maxTries - tries));
            }

            if(String.valueOf(guessWord).equals(wordToGuess)){
                wordGuessed = true;
            }
        }

        if(wordGuessed){
            System.out.println("You won! The word was: " + wordToGuess);
        } else{
            System.out.println("You lost! The word was: " + wordToGuess);
        }
    }

    private void displayedWord(){
        System.out.println("Word: ");
        for(char c : guessWord){
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
package org.example;

public class Main {
    public static void main(String[] args) {
        WordProvider provider = new WordProvider("words.txt");
        String word = provider.getRandom();
        HangmanGame game = new HangmanGame(word);

        game.play();
    }
}

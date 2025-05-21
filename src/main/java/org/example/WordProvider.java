package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordProvider {
    private List<String> words;

    public WordProvider(String filePath){
        words = new ArrayList<>();
        loadWordsFromFile(filePath);
    }

    private void loadWordsFromFile(String filePath){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader( // from new FileReader(filePath) to InputStreamReader
                getClass().getClassLoader().getResourceAsStream(filePath)))){

            String line;
            while((line = reader.readLine()) != null){
                words.add(line.trim().toLowerCase());
            }
        } catch(IOException e){
            System.out.println("Error loading words from file: " + e.getMessage());

            // Adding default words in case of error
            words.addAll(List.of("java", "hangman", "object","class"));
        }
    }

    public String getRandom(){
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }
}

# Hangman Game in Java

A simple console-based Hangman game implemented using Java and Object-Oriented Programming principles.

---

## 🎮 How It Works

- The game randomly selects a word from a list (`words.txt`).
- The user tries to guess the word one letter at a time.
- Each incorrect guess reduces the number of tries left.
- The game ends when the user either guesses the full word or runs out of tries.

---

## 📦 Features

- Console-based interface using `Scanner`
- Random word selection from a file or default list
- Input validation (only one letter at a time, no repeats)
- Object-Oriented structure (`HangmanGame`, `WordProvider`, `Main`)

## ▶️ How to Run

1. Clone or download the project.
2. Make sure you have **Java 17+** and **Maven** installed.
3. Add your word list in `src/main/resources/words.txt` (one word per line).
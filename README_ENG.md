#   **Game "Hangman"**


## Game Rules

###### Objective:
The player must guess the hidden word by entering one letter at a time. If the player guesses a letter correctly, it is revealed in the word. If the guess is incorrect, a part of the hangman is drawn. The goal is to guess the word before the hangman is fully drawn.

###### Gameplay:
The application randomly selects a word from a list.
The word is replaced by underscores _, representing the number of letters in the word.
The player enters a letter:
If the letter is in the word, it is revealed in the correct positions.
It doesn't matter which case the letter is written in.
If the letter is not in the word, the error counter increases, and part of the hangman is drawn.
The player is allowed a certain number of mistakes (usually 6).

###### End of the Game:
The game ends when the player either guesses all the letters in the word (victory) or the error counter reaches its maximum (defeat).
After the game ends, the result and the hidden word are displayed.

###### Game Replay:
After the game ends, the player can choose to start a new game or exit the application.


### **Functionality of the application and console interface menu:**

1) At the start, the application offers the options to start a new game or exit the application.

2) When starting a new game, a word is randomly chosen, and the player begins the process of guessing it.

3) After each letter is entered, the console displays the error count and the current state of the hangman (drawn using ASCII characters).

4) At the end of the game, the result (win or loss) is displayed, and the user is returned to the initial state where they are offered the choice to start a new game or exit the application.
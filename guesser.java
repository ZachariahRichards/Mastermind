import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class guesser {
    //Vector to hold incorrect guesses
    Vector<Character> incorrectColors = new Vector<>();

    //Array to hold the guess
    private char[] guess = new char[4];

    //Constructor that generates the first guess
    public guesser() {
        for (int i = 0; i < 4; i++) {
            char[] initialGuess = getGuess();
            initialGuess[i] = creator.generator();
        }
    }

    //Getter for the guess array
    public char[] getGuess() {
        return guess;
    }

    //Generator for any 'X' grades
    public char newGen(char[] array, int index) {

        //Check to see if that char is in the vector
        if(!found(array[index],incorrectColors)) {
            //If it isn't add it to the vector
            incorrectColors.add(array[index]);
        }

        //Create a list of the letters available
        List<Character> letters = new ArrayList<>();
        letters.add('B');
        letters.add('W');
        letters.add('O');
        letters.add('R');
        letters.add('G');
        letters.add('Y');

        //Loop through the vector
        for (int j = 0; j < incorrectColors.size(); j++){
            int iter = 0;
            char badLetter = incorrectColors.get(j);

            //If the bad letter is in the list remove it
            while(found(badLetter, letters)) {
                if(letters.get(iter) == badLetter) {
                    letters.remove(iter);
                }

                //Only increase iterator if the list did not remove
                else{
                    iter++;
                }
            }
        }

        //Create an int that appropriately represents the list size
        int good = 6 - incorrectColors.size();

        //create a random number and use that to find the letter of the next guess
        if(good != 0) {
            Random random = new Random();
            good = random.nextInt(good);
            return letters.get(good);
        }
        else{
            return letters.getFirst();
        }
    }

    public boolean found(char target, List<Character> list){
        for(char element:list){
            if(element == target){
            return true;
            }
        }
        return false;
    }

    public boolean found(char target, Vector<Character> vector){
        for(char element:vector){
            if(element == target){
                return true;
            }
        }
        return false;
    }

    public void printAIGuess () {
        for (int i = 0; i < guess.length; i++) {
            System.out.print(guess[i] + ", ");
        }
        System.out.println();
    }

    public char[] continueGuessing(char[] grade) {

        //Loop through the grade to create new guess
        for (int i = 0; i < grade.length; i++) {

            //If the grade was 'C' keep that index the same
            if (grade[i] == 'C') {
                guess[i] = guess[i];
            }

            //If the grade is a P replace an X with a P
            else if (grade[i] == 'P') {

                for (int j = 0; j < grade.length; j++) {

                    // if 'X' exists in grade replace with the character at index P
                    // change the grade from X to N so it is not altered
                    if (grade[j] == 'X') {
                        guess[j] = guess[i];
                        grade[j] = 'N';
                        guess[i] = newGen(guess, i);
                        break;
                    }

                    // If there is a P at a different index that is not the same letter or index
                    // swap the characters position and change their grades to N so they arent altered
                    else if (i != j  && guess[i]!=guess[j] && grade[j] == 'P') {

                        char temp = guess[i];
                        char temp2 = guess[j];

                        guess[j] = temp;
                        guess[i] = temp2;

                        grade[i] = 'N';
                        grade[j] = 'N';

                        break;
                    }

                }
            }
            // Create new letter
            else if (grade[i] == 'X'){
                guess[i] = newGen(guess, i);
            }
        }
        return guess;
    }






}

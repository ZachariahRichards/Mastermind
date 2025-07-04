import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class game {
    public game(char request, int allowedGuesses) {
        int iteration=0;
        Scanner scanner = new Scanner(System.in);
        char[] grabbedArray = new char[4];
        boolean correct = false;
        System.out.println("You will have 6 colors to apply to your pattern");
        System.out.println("Enter O-for orange, Y-for yellow, B-for Blue");
        System.out.println("G-for Green, R for Red, and W-for White. Your pattern must be a length of 4 colors.");
        System.out.println("Grading- C means it is correct and in the right place");
        System.out.println("P means the color is in the pattern, but its in the wrong location");
        System.out.println("X means that color is not in this at all");

        //User is guessing
        if(request == '1'){
            //Create random array
            creator AICreates = new creator();

            //Get random array
            char[] createdArray = AICreates.getColor();

            //Loop through grading and guessing
            while(iteration < allowedGuesses) {

                //Get guess
                System.out.println("Please enter your next pattern O, Y, B, G, W, R (length of 4)");
                String inputString = scanner.nextLine();
                String inputUpper = inputString.toUpperCase();

                //Verify pattern meets parameters
                while(!isGoodPattern(inputUpper)) {
                    System.out.println("Your entry was incorrect try again. O, Y, B, G, W, R (length of 4)");
                    inputUpper = scanner.nextLine();
                }

                //Make guess an array
                grabbedArray = inputUpper.toCharArray();

                //Make new instance of grader to grade new guess
                grader grade = new grader(createdArray, grabbedArray);

                //Print the guess
                printGuessUser(grabbedArray);

                //Print the new accuracy
                grade.getAccuracy();
                grade.printAccuracy();

                if(Arrays.equals(grabbedArray, createdArray)){
                    correct = true;
                    System.out.println("Congratulations, You have successfully beaten me.");
                    break;
                }
                iteration+= 1;
            }

            AICreates.printCreation();

        }




        //AI guessing
        else if (request == '2') {

            //Player creates pattern
            String pattern = scanner.nextLine();
            String playerPattern = pattern.toUpperCase();

            //Verify pattern
            while(!isGoodPattern(playerPattern)) {
                System.out.println("Your entry was incorrect try again. O, Y, B, G, W, R (length of 4)");
                playerPattern = scanner.nextLine();
            }

            grabbedArray = playerPattern.toCharArray();

            //Takes CPUs 1st guess
            guesser guess = new guesser();
            char[] AIGuess = guess.getGuess();
            guess.printAIGuess();

            //Grades first guess
            grader grade = new grader(grabbedArray, AIGuess);
            char[] grading = grade.getAccuracy();
            grade.printAccuracy();
            iteration++;

            //If first guess was incorrect iterates through guessing
            while(iteration<allowedGuesses && !correct) {

                //Continue guessing and grading
                char[] guessingContinuation = guess.continueGuessing(grading);
                grade=new grader(grabbedArray, guessingContinuation);
                guess.printAIGuess();
                grade.getAccuracy();
                grade.printAccuracy();

                //If the arrays are identical correct is true
                if(Arrays.equals(grabbedArray, guess.getGuess())){
                    correct = true;
                    System.out.println("HaHaHa I won");
                }

                iteration+= 1;
            }

            System.out.println("You have outsmarted me!");
        }

        //PVP
        else if(request == '3'){
            //Get players names
            System.out.println("Player 1 please enter your name");
            String p1Name = scanner.nextLine();

            System.out.println("Player 2 please enter your name.");
            String p2Name = scanner.nextLine();

            clearConsole();

            //Get pattern to be guessed
            System.out.println(p1Name + " please enter the pattern (O, Y, B, G, W, R) (length of 4)");
            String p1Pattern = scanner.nextLine();
            String p1Upper = p1Pattern.toUpperCase();

            //Verify inputs
            while(!isGoodPattern(p1Upper)) {
                System.out.println("Your entry was incorrect try again. O, Y, B, G, W, R(length of 4)");
                p1Upper = scanner.nextLine();
            }

            //Create array and pass that pattern into array
            char[] p1Array = p1Upper.toCharArray();
            clearConsole();

            //Loop through guesses by P2 until game is over
            while(iteration<allowedGuesses && !correct) {

                // Get guess
                System.out.println(p2Name +" please enter your guess. (O, Y, B, G, W, R)(length of 4)");
                String p2Guess = scanner.nextLine();
                String p2Upper = p2Guess.toUpperCase();

                //Verify inputs
                while(!isGoodPattern(p2Upper)) {
                    System.out.println("Your entry was incorrect try again. O, Y, B, G, W, R(length of 4)");
                    p2Upper = scanner.nextLine();
                }

                //Create char array from guess string
                char[] p2Array = p2Upper.toCharArray();
                printGuessUser(p2Array);

                //Grade and print
                grader grade=new grader(p1Array, p2Array);
                grade.getAccuracy();
                grade.printAccuracy();

                iteration++;

                if(Arrays.equals(p2Array, p1Array)){
                    correct = true;
                    System.out.println(p2Name + " wins");
                }
            }
            printGuessUser(p1Array);
            System.out.println(p1Name +" wins");
        }
    }

    //Used to print arrays user inputs
    public void printGuessUser(char[] grabbedArray){

        for(int i=0;i<grabbedArray.length;i++){
            System.out.print(grabbedArray[i] + ", ");
        }

        System.out.println();
    }


    // create enough lines to clear console
    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

    }

    //Check pattern inputs
    public static boolean isGoodPattern(String pattern){
        boolean good = true;

        if (pattern.length() != 4){
            good = false;
        }

        for(int i = 0; i < 4; i++){
            if(pattern.charAt(i) != 'B' && pattern.charAt(i) != 'R' && pattern.charAt(i) != 'W'
            && pattern.charAt(i) != 'G' && pattern.charAt(i) != 'Y' && pattern.charAt(i) != 'O'){
                good = false;
            }
        }
        return good;
    }
}
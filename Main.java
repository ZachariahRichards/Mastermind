//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char preference = 0;
        do {
            System.out.println("Welcome to Mastermind");
            System.out.println("If you would like the computer to create a pattern enter 1, if you would");
            System.out.println("prefer to create the pattern enter 2.");
            System.out.println("If you would like to play PVP enter 3.");

            //Assign what style the user chooses to preference
            preference = scanner.next().charAt(0);
        }while(preference!='1' && preference != '2' && preference != '3');

        System.out.println("How many guesses would you like to allow");
        int numGuesses = scanner.nextInt();
        game play = new game(preference, numGuesses);

    }
}
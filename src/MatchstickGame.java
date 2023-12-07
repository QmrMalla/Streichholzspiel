import java.util.Scanner;
import java.util.Random;

public class MatchstickGame {
    static Scanner scanner;
    //the number of matches and move can be changed 
	private static final int INITIAL_MATCHES = 21;
	private static final int MAX_MOVE = 3;

    public static void main(String[] args) {
        System.out.println("Welcome to the Matchstick Game!");
        playGame(INITIAL_MATCHES);
    }

    public static void playGame(int matches) {
        System.out.println("Starting number of all matches is " + matches);

        try {
            scanner = new Scanner(System.in);

            while (matches > 0) {
                matches = playerPlays(matches);
                matches = computerPlays(matches);
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public static int playerPlays(int matches) {
        int playerMove = getPlayerMove();
        matches -= playerMove;
        System.out.println("remaining matches " + matches);
        if (matches <= 0) {
            System.out.println("You lost! Better luck next time.");
        }
        return matches;
    }

    public static int computerPlays(int matches) {
        int computerMove = calculateComputerMove(matches);
        System.out.println("Computer takes " + computerMove + " matches.");
        matches -= computerMove;
        System.out.println("remaining matches " + matches);
        if (matches <= 0) {
            System.out.println("Computer wins! Good game.");
        }
        return matches;
    }

    public static int getPlayerMove() {
        while (true) {
            try {
                System.out.print("How many matches will you take (1-3)? ");
                int move = Integer.parseInt(scanner.nextLine());

                if (1 <= move && move <= MAX_MOVE) {
                    return move;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and " + MAX_MOVE + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
    //this wininng Stratigie for Computer
    public static int calculateComputerMove(int matches) {
        Random random = new Random();

        if (matches % (MAX_MOVE + 1) == 0) {
            return random.nextInt(MAX_MOVE) + 1;
        } else {
            return matches % (MAX_MOVE + 1);
        }
    }
}

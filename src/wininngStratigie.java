import java.util.Random;

public class wininngStratigie {
	private static final int MAX_MOVE = 3;
	public static int calculateComputerMove(int matches) {
        Random random = new Random();

        if (matches % (MAX_MOVE + 1) == 0) {
            return random.nextInt(MAX_MOVE) + 1;
        } else {
            return matches % (MAX_MOVE + 1);
        }
    }
}

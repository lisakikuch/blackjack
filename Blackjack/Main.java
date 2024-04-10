import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        System.out.println("Welcome to Blackjack!");

        boolean keepPlaying = true;
        while (keepPlaying && !game.isDeckEmpty()) {
            game.playRound();

            System.out.println("Play another round? Enter 'yes' or 'no': ");
            String input = scanner.nextLine().trim().toLowerCase();
            if ("no".equals(input)) {
                keepPlaying = false;
            } else if ("yes".equals(input)) {
                keepPlaying = true;
            }
        }

        game.printFinalScore();
        System.out.println("Hope you had fun!");
        scanner.close();

    }
}

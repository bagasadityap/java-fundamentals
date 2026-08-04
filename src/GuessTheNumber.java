import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GuessTheNumber {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int number = 1;
        int i = 0;
        int answer = ThreadLocalRandom.current().nextInt(1, 101);

        while (number != 0) {
            i++;
            System.out.println("===== GUESS THE NUMBER FROM 1 TO 100 =====");
            System.out.println("==== input 0 to exit the game ====");
            System.out.print("Your Guess: ");
            int guess = sc.nextInt();
            sc.nextLine();
            if (guess == 0) {
                break;
            }
            if (guess == answer) {
                System.out.println("Tebakan anda benar!! anda menebak sebanyak " + i + " kali");
                break;
            } else if (guess > answer) {
                System.out.println("Tebakan terlalu tinggi");
            } else {
                System.out.println("Tebakan terlalu  rendah");
            }
            System.out.println("\n");
        }
    }

}

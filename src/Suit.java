import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Suit {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("|| Selamat Datang di Game SUIT ||");
        System.out.println("=================================");

        System.out.print("Mau main berapa kali?...");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Pilih: \n 1. Batu \n 2. Gunting \n 3. Kertas ");
            System.out.print("Masukkan jawaban kamu: ");
            System.out.println(suit(sc.nextInt()));
        }
    }

    public static String suit(int x) {
        String result = "";
        String lawan = "";
        int rand = ThreadLocalRandom.current().nextInt(1, 4);

        if (rand == 1) {
            lawan = "Batu";
        } else if (rand == 2) {
            lawan = "Gunting";
        } else {
            lawan = "Kertas";
        }

        if (x == rand) {
            result = "Imbang";
        } else if (x == 1) {
            if (rand == 2) {
                result = "Menang";
            } else {
                result = "Kalah";
            }
        } else if (x == 2) {
            if (rand == 1) {
                result = "Kalah";
            } else {
                result = "Menang";
            }
        } else if (x == 3) {
            if (rand == 1) {
                result = "Menang";
            } else {
                result = "Kalah";
            }
        } else {
            return "Maksimal 3 banggg!!!";
        }

        return result + "!!! Lawan kamu memilih: " + lawan ;
    }
}
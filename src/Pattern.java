import java.util.Arrays;

public class Pattern {
    static void main() {
        String no1_1 = no1_1(6, 2);
        String no1_2 = no1_2(4, 2);
        int[] numbers = {6, 6, 5, 9};
        int[] no3 = sort(numbers);
        char[] alphabet = {'M', 'A', 'K', 'A', 'N', 'N', 'A', 'S'};
        char[] no4 = sortAlphabet(alphabet);

        System.out.println("No 1.1 \t: " + no1_1);
        System.out.println("No 1.2 \t: " + no1_2);
        System.out.println("No 2 \t: " + Arrays.toString(no3));
        System.out.println("No 2 \t: " + Arrays.toString(no4));
    }

    public static String no1_1 (int n, long start) {
        String result = "";
        long res = start;

        for (int i = 1; i <= n; i++) {
            result = result + " " + res;
            if (i == 1 || i == 2 || i == 3) {
                res += 2;
            } else {
                res *= 2;
            }
        }

        return result;
    }

    public static String no1_2 (int n, long start) {
        String result = "" + start;
        long temp1 = start;
        long temp2 = start;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                temp2 *= temp1;

                result += " " + temp2;
            } else {
                temp2 *= temp1;
                temp1 *= temp1;

                result += " " + temp2;
            }
        }

        return result;
    }

    public static int[] sort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

        return numbers;
    }

    public static char[] sortAlphabet(char[] abc) {
        for (int i = 0; i < abc.length - 1; i++) {
            for (int j = 0; j < abc.length - 1 - i; j++) {
                if (abc[j] > abc[j + 1]) {
                    char temp = abc[j];
                    abc[j] = abc[j + 1];
                    abc[j + 1] = temp;
                }
            }
        }

        return abc;
    }
}


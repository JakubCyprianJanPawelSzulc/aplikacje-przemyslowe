import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbe: ");
        int number = scanner.nextInt();

        boolean isArmstrong = isArmstrongNumber(number);
        System.out.println("Czy " + number + " jest liczba Armstronga? Odpowiedz: " + isArmstrong);
        scanner.close();
    }

    public static boolean isArmstrongNumber(int num) {
        int originalNum = num;
        int sum = 0;
        int numberOfDigits = (int) Math.log10(num) + 1;

        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, numberOfDigits);
            num /= 10;
        }

        return sum == originalNum;
    }
}

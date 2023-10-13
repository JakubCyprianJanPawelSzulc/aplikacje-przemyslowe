import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        boolean isCorrect = false;
        while (!isCorrect) {
            System.out.print("Podaj liczbe naturalna: ");
            n = scanner.nextInt();
            scanner.nextLine();
            if (n > 0) {
                isCorrect = true;
            }
        }
        scanner.close();

        System.out.println(returnPyramid(n));
    }

    public static String returnPyramid(int n){
        StringBuilder myString = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++)
                myString.append("x");
            myString.append("\n");
        }
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++)
                myString.append("x");
            myString.append("\n");
        }
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < n - i; j++)
                myString.append(" ");
            for (int j = 0; j < i; j++)
                myString.append("x");
            myString.append("\n");
        }
        for (int i = 1; i <= n; i++) {
            for (int j=0; j < n - i; j++)
                myString.append(" ");
            for (int j = 0; j < i; j++)
                myString.append("x");
            myString.append("\n");
        }
        return myString.toString();
    }
}
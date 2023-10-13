import java.util.Scanner;

enum Planets {
    Merkury(0.2408467), Wenus(0.61519726), Mars(1.8808158), Jowisz(11.862615), Saturn(29.447498), Uran(84.016846), Neptun(164.79132);

    private final double earthYear;

    Planets(double earthYear) {
        this.earthYear = earthYear;
    }

    public double getEarthYear() {
        return earthYear;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj wiek w sekundach: ");
        double seconds = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Podaj planete: ");
        String planet = scanner.nextLine();
        scanner.close();
        System.out.println("Wiek na planecie " + planet + " to " + calculateAge(seconds, planet) + " lat.");
    }

    public static double calculateAge(double seconds, String planet) {
        double earthYear = 31557600;
        double age = 0;

        switch (planet) {
            case "Merkury":
                age = seconds / (earthYear * Planets.Merkury.getEarthYear());
                break;
            case "Wenus":
                age = seconds / (earthYear * Planets.Wenus.getEarthYear());
                break;
            case "Mars":
                age = seconds / (earthYear * Planets.Mars.getEarthYear());
                break;
            case "Jowisz":
                age = seconds / (earthYear * Planets.Jowisz.getEarthYear());
                break;
            case "Saturn":
                age = seconds / (earthYear * Planets.Saturn.getEarthYear());
                break;
            case "Uran":
                age = seconds / (earthYear * Planets.Uran.getEarthYear());
                break;
            case "Neptun":
                age = seconds / (earthYear * Planets.Neptun.getEarthYear());
                break;
            default:
                System.out.println("Nie ma takiej planety!");
                System.exit(1);
        }
        age = Math.round(age * 100.0) / 100.0;
        return age;
    }
}

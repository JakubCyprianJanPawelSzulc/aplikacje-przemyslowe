package edu;

public class Main {
    public static void main(String[] args) {

        double[] input = {1.0, 2.0, 3.0, 4.0};

        Compute compute = new Compute(input);

        System.out.println("Średnia");
        System.out.println(compute.getMean());

        System.out.println("Odchylenie standardowe");
        System.out.println(compute.getDeviation());

        System.out.println("Wariancja");
        System.out.println(compute.getVariance());

    }
}
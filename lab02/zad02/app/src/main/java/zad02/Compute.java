package zad02;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Compute {
    public static void main(String[] args) {
        double[] data = { 1.0, 2.0, 3.0, 4.0, 5.0 };
        double mean = calculateMean(data);
        System.out.println("Średnia arytmetyczna: " + mean);

        double stdDev = calculateStandardDeviation(data);
        System.out.println("Odchylenie standardowe: " + stdDev);

        double variance = calculateVariance(data);
        System.out.println("Wariancja: " + variance);
    }

    public static double calculateMean(double[] data) {
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (double value : data) {
            stats.addValue(value);
        }
        return stats.getMean();
    }

    public static double calculateStandardDeviation(double[] data) {
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (double value : data) {
            stats.addValue(value);
        }
        return stats.getStandardDeviation();
    }

    public static double calculateVariance(double[] data) {
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (double value : data) {
            stats.addValue(value);
        }
        return stats.getVariance();
    }
}

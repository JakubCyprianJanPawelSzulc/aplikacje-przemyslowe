package edu;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Compute {
    private double[] input;

    public Compute() {
    }

    public Compute(double[] input) {
        this.input = input;
    }

    public double getMean() {
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (double value : input) {
            stats.addValue(value);
        }
        return stats.getMean();
    }

    public double getDeviation() {
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (double value : input) {
            stats.addValue(value);
        }
        return stats.getStandardDeviation();
    }

    public double getVariance() {
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (double value : input) {
            stats.addValue(value);
        }
        return stats.getVariance();
    }
}

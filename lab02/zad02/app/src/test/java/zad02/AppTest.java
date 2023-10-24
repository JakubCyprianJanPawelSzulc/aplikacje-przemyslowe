package zad02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void testCalculateMean() {
        double[] data = {1.0, 2.0, 3.0, 4.0, 5.0};
        double expectedMean = 3.0;
        double calculatedMean = Compute.calculateMean(data);
        assertEquals(expectedMean, calculatedMean, 0.001);
    }

    @Test
    void testCalculateStandardDeviation() {
        double[] data = {1.0, 2.0, 3.0, 4.0, 5.0};
        double expectedStdDev = 1.5811;
        double calculatedStdDev = Compute.calculateStandardDeviation(data);
        assertEquals(expectedStdDev, calculatedStdDev, 0.001);
    }

    @Test
    void testCalculateVariance() {
        double[] data = {1.0, 2.0, 3.0, 4.0, 5.0};
        double expectedVariance = 2.5;
        double calculatedVariance = Compute.calculateVariance(data);
        assertEquals(expectedVariance, calculatedVariance, 0.001);
    }
}

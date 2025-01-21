/**
 * The class WeatherPatterns finds the longest span of days in which
 * each day’s temperature is higher than on the previous day in that sequence.
 *
 * @author Zach Blick
 * @author Landon Moceri
 */

public class WeatherPatterns {
    /**
     * Longest Warming Trend
     * @param temperatures
     * @return the longest run of days with increasing temperatures
     */
    public static int longestWarmingTrend(int[] temperatures) {
        // Initialize a map to store the longest sequence of temperatures up to any given temperature
        int[] sequenceLengths = new int[200];
        // Keep track of the longest sequence observed
        int longestSequence = 0;

        // Iterate through the temperatures
        for (int temp : temperatures) {
            // Find the length of a sequence leading up to the current temperature if it exists
            int currentLength = 1;
            for (int t = temp - 1; t >= 0; t--) {
                if (sequenceLengths[t] > 0) {
                    currentLength = sequenceLengths[t] + 1;
                    break;
                }
            }
            // Update the sequence length for the current temperature
            sequenceLengths[temp] = currentLength;
            // Update the longest sequence if necessary
            longestSequence = Math.max(longestSequence, currentLength);
        }

        return longestSequence;
    }
}

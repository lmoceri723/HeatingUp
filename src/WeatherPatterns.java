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

    // These are based on the hottest and coldest temperatures ever recorded (134 and -128) with a bit of extra room
    static int MAX_TEMP = 150;
    static int MIN_TEMP = -150;
    static int TEMP_RANGE = MAX_TEMP - MIN_TEMP + 1;

    // Used to make all temperatures positive to be used as indices
    static int MAKE_POSITIVE = MIN_TEMP * -1;

    // I stand by this approach, as it has a space complexity of O(E) at its worst case
    // While adjacency lists and matrices were listed to have space complexities of O(V+E) and O(V^2),
    // Additionally, they both have a time complexity of O(V^2) to build and O(V) to solve
    // This approach has a time complexity of O(V^2) to solve while building along the way
    public static int longestWarmingTrend(int[] temperatures) {
        // Initialize a map to store the longest sequence of temperatures up to any given temperature
        int[] sequenceLengths = new int[TEMP_RANGE];
        // Keep track of the longest sequence observed
        int longestSequence = 0;

        // Iterate through the temperatures
        for (int temp : temperatures) {
            // Find the length of a sequence leading up to the current temperature if it exists
            int currentLength = 1;
            for (int t = temp - 1; t >= MIN_TEMP; t--) {
                if (sequenceLengths[t + MAKE_POSITIVE] > 0) {
                    currentLength = sequenceLengths[t + MAKE_POSITIVE] + 1;
                    break;
                }
            }
            // Update the sequence length for the current temperature
            sequenceLengths[temp + MAKE_POSITIVE] = currentLength;
            // Update the longest sequence if necessary
            longestSequence = Math.max(longestSequence, currentLength);
        }

        return longestSequence;
    }
}

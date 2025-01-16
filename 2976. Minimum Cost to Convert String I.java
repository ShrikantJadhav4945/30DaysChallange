import java.util.*;

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        // Convert char[] to String[]
        String[] originalStr = new String[original.length];
        String[] changedStr = new String[changed.length];
        for (int i = 0; i < original.length; i++) {
            originalStr[i] = String.valueOf(original[i]);
            changedStr[i] = String.valueOf(changed[i]);
        }

        int INF = Integer.MAX_VALUE / 2; // Large value for unreachable substitutions
        int n = 26; // Number of letters in the alphabet
        int[][] minCost = new int[n][n]; // Substitution cost between characters

        // Initialize substitution costs
        for (int i = 0; i < n; i++) {
            Arrays.fill(minCost[i], INF);
            minCost[i][i] = 0; // Cost to substitute a character with itself is 0
        }

        // Fill the substitution costs from the input
        for (int i = 0; i < originalStr.length; i++) {
            int from = originalStr[i].charAt(0) - 'a';
            int to = changedStr[i].charAt(0) - 'a';
            minCost[from][to] = Math.min(minCost[from][to], cost[i]);
        }

        // Apply Floyd-Warshall to compute minimum substitution costs between all pairs
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
                }
            }
        }

        // Transform source to target using minimum substitution costs
        if (source.length() != target.length()) {
            return -1; // Impossible if lengths differ
        }

        long totalCost = 0;
        for (int i = 0; i < source.length(); i++) {
            char sChar = source.charAt(i);
            char tChar = target.charAt(i);

            if (sChar != tChar) {
                int costToTransform = minCost[sChar - 'a'][tChar - 'a'];
                if (costToTransform == INF) {
                    return -1; // No valid transformation exists
                }
                totalCost += costToTransform;
            }
        }

        return totalCost;
    }
}
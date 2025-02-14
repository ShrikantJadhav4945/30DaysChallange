import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Sort envelopes by width in ascending order.
        // If widths are the same, sort by height in descending order.
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // Descending order of height
            }
            return a[0] - b[0]; // Ascending order of width
        });

        // Extract the heights
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }

        // Find the length of LIS on heights
        return lengthOfLIS(heights);
    }

    private int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();

        for (int num : nums) {
            int index = Collections.binarySearch(lis, num);
            if (index < 0) {
                index = -(index + 1);
            }
            if (index == lis.size()) {
                lis.add(num);
            } else {
                lis.set(index, num);
            }
        }

        return lis.size();
    }
}

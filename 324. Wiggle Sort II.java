import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int left = (n - 1) / 2; // Middle of the sorted array
        int right = n - 1;      // End of the sorted array

        // Place elements in wiggle order
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = sorted[left--]; // Smaller elements
            } else {
                nums[i] = sorted[right--]; // Larger elements
            }
        }
    }
}
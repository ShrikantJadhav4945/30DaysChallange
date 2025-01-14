import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2); 
        int count = 0;

        
        for (int i = 0; i < arr1.length; i++) {
            int num = arr1[i];
            if (isValid(num, arr2, d)) {
                count++;
            }
        }

        return count;
    }

    private boolean isValid(int num, int[] arr2, int d) {
        int left = 0, right = arr2.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr2[mid] == num) {
                return false; 
            }
            if (arr2[mid] < num - d) {
                left = mid + 1;
            } else if (arr2[mid] > num + d) {
                right = mid - 1;
            } else {
                return false; 
            }
        }
        return true; 
    }
}

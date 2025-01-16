class Solution {
    public int maxProduct(String s) {
        int n = s.length();
        int maxProduct = 0;
        // Array to store the lengths of palindromic subsequences
        int[] lengths = new int[1 << n];
        
        // Precompute lengths of palindromic subsequences
        for (int mask = 1; mask < (1 << n); mask++) {
            if (isPalindrome(s, mask)) {
                lengths[mask] = Integer.bitCount(mask);
            }
        }
        
        // Iterate over all pairs of masks to calculate maximum product
        for (int mask1 = 1; mask1 < (1 << n); mask1++) {
            for (int mask2 = mask1 + 1; mask2 < (1 << n); mask2++) {
                // Ensure the two subsequences are disjoint
                if ((mask1 & mask2) == 0) {
                    maxProduct = Math.max(maxProduct, lengths[mask1] * lengths[mask2]);
                }
            }
        }
        
        return maxProduct;
    }
    
    // Helper function to check if a subsequence is a palindrome
    private boolean isPalindrome(String s, int mask) {
        int left = 0, right = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        
        // Build the subsequence based on the bitmask
        for (int i = 0; i < s.length(); i++) {
            if ((mask & (1 << i)) != 0) {
                sb.append(s.charAt(i));
            }
        }
        
        // Check if the subsequence is a palindrome
        String subsequence = sb.toString();
        int l = 0, r = subsequence.length() - 1;
        while (l < r) {
            if (subsequence.charAt(l) != subsequence.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        
        return true;
    }
}

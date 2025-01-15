class Solution {
    void matchPairs(int n, char nuts[], char bolts[]) {
        // Define the order of precedence for nuts and bolts
        String order = "!#$%&*?@^";

        // Create a mapping of characters to their index in the order
        int[] orderMap = new int[256];
        Arrays.fill(orderMap, -1); // Initialize all values to -1
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i)] = i;
        }

        // Convert char arrays to Character arrays
        Character[] nutsArr = new Character[n];
        Character[] boltsArr = new Character[n];
        for (int i = 0; i < n; i++) {
            nutsArr[i] = nuts[i];
            boltsArr[i] = bolts[i];
        }

        // Sort the Character arrays using the order map
        Arrays.sort(nutsArr, (a, b) -> orderMap[a] - orderMap[b]);
        Arrays.sort(boltsArr, (a, b) -> orderMap[a] - orderMap[b]);

        // Convert the sorted Character arrays back to char arrays
        for (int i = 0; i < n; i++) {
            nuts[i] = nutsArr[i];
            bolts[i] = boltsArr[i];
        }
    }
}


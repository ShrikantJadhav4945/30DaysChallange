import java.util.*;

class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // Memoization map to store results for specific needs
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return dfs(price, special, needs, memo);
    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> memo) {
        // If this state has been computed before, return the stored result
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }

        // Calculate the direct purchase cost without any special offers
        int directCost = 0;
        for (int i = 0; i < needs.size(); i++) {
            directCost += needs.get(i) * price.get(i);
        }

        int minCost = directCost;

        // Try using each special offer
        for (List<Integer> offer : special) {
            List<Integer> updatedNeeds = new ArrayList<>(needs);
            boolean isValid = true;

            // Check if the special offer can be applied
            for (int i = 0; i < needs.size(); i++) {
                updatedNeeds.set(i, updatedNeeds.get(i) - offer.get(i));
                if (updatedNeeds.get(i) < 0) { // Offer exceeds the current needs
                    isValid = false;
                    break;
                }
            }

            // If the offer is valid, calculate the cost recursively
            if (isValid) {
                minCost = Math.min(minCost, offer.get(offer.size() - 1) + dfs(price, special, updatedNeeds, memo));
            }
        }

        // Store the result in the memoization map
        memo.put(needs, minCost);
        return minCost;
    }
}
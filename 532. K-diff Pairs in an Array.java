import java.util.*;

class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0; 

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        for (int i = 0; i < keys.size(); i++) {
            int num = keys.get(i);
            int freq = map.get(num);

            if (k == 0) {
                if (freq > 1) {
                    count++;
                }
            } else {
                if (map.containsKey(num + k)) {
                    count++;
                }
            }
        }

        return count;
    }
}

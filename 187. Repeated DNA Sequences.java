import java.util.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 10) return result;

        Set<String> set = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        // Traverse the string with a sliding window of size 10
        for (int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);
            if (set.contains(substring)) {
                repeated.add(substring);
            } else {
                set.add(substring);
            }
        }

        // Convert the set of repeated sequences to a list
        result.addAll(repeated);
        return result;
    }
}

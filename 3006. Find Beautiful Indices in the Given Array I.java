import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> result = new ArrayList<>();
        List<Integer> aIndices = new ArrayList<>();
        List<Integer> bIndices = new ArrayList<>();
        
        // Find all indices where `a` and `b` start in `s`
        for (int i = 0; i <= s.length() - a.length(); i++) {
            if (s.substring(i, i + a.length()).equals(a)) {
                aIndices.add(i);
            }
        }
        
        for (int i = 0; i <= s.length() - b.length(); i++) {
            if (s.substring(i, i + b.length()).equals(b)) {
                bIndices.add(i);
            }
        }
        
        // Use two-pointer approach to check the condition |i - j| <= k
        int j = 0;
        for (int i : aIndices) {
            while (j < bIndices.size() && bIndices.get(j) < i - k) {
                j++; // Skip invalid `b` indices
            }
            if (j < bIndices.size() && Math.abs(i - bIndices.get(j)) <= k) {
                result.add(i);
            }
        }
        
        return result;
    }
}

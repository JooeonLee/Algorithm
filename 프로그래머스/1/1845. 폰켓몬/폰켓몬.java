import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> kinds = new HashSet<>();

        for (int num : nums) {
            kinds.add(num);
        }

        int maxSelect = nums.length / 2;
        return Math.min(kinds.size(), maxSelect);
    }
}

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int kinds = (int) Arrays.stream(gems).distinct().count();
        
        Map<String, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int bestLeft = 0, bestLen = Integer.MAX_VALUE;
        
        while(right < gems.length) {
            window.merge(gems[right], 1, Integer::sum);
            
            while(window.size() == kinds) {
                if(right - left + 1 < bestLen) {
                    bestLen = right - left + 1;
                    bestLeft = left;
                }
                
                window.merge(gems[left], -1, Integer::sum);
                if(window.get(gems[left]) == 0)
                    window.remove(gems[left]);
                left++;
            }
            right++;
        }
        
        return new int[]{bestLeft+1, bestLeft + bestLen};
    }
}
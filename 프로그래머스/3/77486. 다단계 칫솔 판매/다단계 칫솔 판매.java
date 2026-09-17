import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Integer> index = new HashMap<>();
        int[] parents = new int[enroll.length];
        int[] answer = new int[enroll.length];
        
        for(int i=0; i<enroll.length; i++) {
            index.put(enroll[i], i);
        }
        for(int i=0; i<enroll.length; i++) {
            parents[i] = index.getOrDefault(referral[i], -1);
        }
        for(int i=0; i<seller.length; i++) {
            String curr = seller[i];
            int currIdx = index.get(curr);
            int currPrice = amount[i] * 100;
            answer[currIdx] += currPrice - currPrice/10;
            
            int parentIdx = parents[currIdx];
            
            while(currPrice / 10 > 0 && parentIdx != -1) {
                answer[parentIdx] += currPrice/10 - currPrice/100;
                currPrice = currPrice / 10;
                currIdx = parentIdx;
                parentIdx = parents[currIdx];
            }
        }
        return answer;
    }
}
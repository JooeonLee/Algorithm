import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] aArr = measure(yellow);
        
        for(int a : aArr) {
            int b = yellow / a;
            
            int currBrown = (a+2) * (b+2) - yellow;
            if(currBrown == brown) {
                answer.add(b+2);
                answer.add(a+2);
            }
        }
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    public int[] measure(int yellow) {
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i=1; i<=Math.sqrt(yellow); i++)
            if(yellow % i == 0)
                result.add(i);
        
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
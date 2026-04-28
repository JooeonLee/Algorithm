import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        int[] sortedArr = Arrays.stream(citations)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
        
        int h = 0;
        for(int i=0; i<sortedArr.length; i++) {
            if(sortedArr[i] >= i+1)
                h = i+1;
            else
                break;
        }
        
        return h;
    }
}
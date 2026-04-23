import java.util.*;

import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        ArrayList<Integer> answer = new ArrayList<>();;
        int oddCnt = 0;
        int evenCnt = 0;
        
        for(int num : num_list) {
            if(num % 2 == 1)
                oddCnt++;
            else
                evenCnt++;
        }
        
        answer.add(evenCnt);
        answer.add(oddCnt);
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
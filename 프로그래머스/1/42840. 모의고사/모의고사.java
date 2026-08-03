import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        
        for(int i=1; i<=answers.length; i++) {
            int curr = answers[i-1];
            int case1 = i%5==0 ? 5 : i%5;
            if(curr == case1)
                cnt1++;
            
            int case2Idx = (i%8==0 ? 8 : i%8) -1;
            int[] case2Arr = {2,1,2,3,2,4,2,5};
            int case2 = case2Arr[case2Idx];
            if(curr == case2)
                cnt2++;
            
            int case3Idx = (i%10==0 ? 10 : i%10) - 1;
            int[] case3Arr = {3,3,1,1,2,2,4,4,5,5};
            int case3 = case3Arr[case3Idx];
            if(curr == case3)
                cnt3++;
        }
        int maxCnt = Math.max(cnt1, Math.max(cnt2, cnt3));
        
        if(cnt1 == maxCnt)
            answer.add(1);
        if(cnt2 == maxCnt)
            answer.add(2);
        if(cnt3 == maxCnt)
            answer.add(3);
        
        return answer.stream()
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
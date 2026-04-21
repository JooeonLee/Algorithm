import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] answer3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int cnt1=0, cnt2=0, cnt3=0;
        
        for(int i=0; i<answers.length; i++) {
            if(i%5+1 == answers[i])
                cnt1++;
            if(answer2[i%8] == answers[i])
                cnt2++;
            if(answer3[i%10] == answers[i])
                cnt3++;
        }
        
        int max = Math.max(cnt1, Math.max(cnt2, cnt3));
        ArrayList<Integer> answer = new ArrayList<>();
        
        if(max == cnt1)
            answer.add(1);
        if(max == cnt2)
            answer.add(2);
        if(max == cnt3)
            answer.add(3);
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
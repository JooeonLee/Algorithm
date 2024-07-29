import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> daysList = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++) {
            int remainingProgress = 100 - progresses[i];
            int days = (int)Math.ceil((double)remainingProgress / speeds[i]);
            daysList.add(days);
        }
        
        List<Integer> answerList = new ArrayList<>();
        
        int distributeDay = daysList.get(0);
        int count = 1;
        
        for(int i=1; i<daysList.size(); i++) {
            if(daysList.get(i) <= distributeDay) {
                count++;
            } else {
                answerList.add(count);
                distributeDay = daysList.get(i);
                count = 1;
            }
        }
        
        answerList.add(count);
        
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
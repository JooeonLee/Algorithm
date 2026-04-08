import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> daysList = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++) {
            int remain = 100 - progresses[i];
            if(remain%speeds[i] == 0)
                daysList.add(remain/speeds[i]);
            else
                daysList.add(remain/speeds[i] + 1);
        }
        
        ArrayList<Integer> answerList = new ArrayList<>();
        int count = 1;
        int daysD = daysList.get(0);
        
        for(int i=1; i<daysList.size(); i++) {
            int current = daysList.get(i);
            if(daysD >= current)
                count++;
            else {
                answerList.add(count);
                count = 1;
                daysD = current;
            }
        }
        answerList.add(count);
        
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}
import java.util.*;

class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        
        for(int currH : array) {
            if(currH > height)
                answer++;
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int maxW = 0;
        int maxH = 0;
        
        for(int[] rec : sizes) {
            int currW = rec[0];
            int currH = rec[1];
            int currMax = 0;
            int currMaxTurn = 0;
            
            currMax = Math.max(maxW, currW) * Math.max(maxH, currH);
            currMaxTurn = Math.max(maxW, currH) * Math.max(maxH, currW);
            
            if(currMax < currMaxTurn) {
                maxW = Math.max(maxW, currW);
                maxH = Math.max(maxH, currH);
            }
            else {
                maxW = Math.max(maxW, currH);
                maxH = Math.max(maxH, currW);
            }
        }
        answer = maxW * maxH;
        return answer;
    }
}
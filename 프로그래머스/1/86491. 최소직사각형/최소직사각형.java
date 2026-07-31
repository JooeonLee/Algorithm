import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;
        
        for(int[] e : sizes) {
            int currArea1 = 0;
            int currWidth1 = maxWidth;
            int currHeight1 = maxHeight;
            if(e[0] > maxWidth)
                currWidth1 = e[0];
            if(e[1] > maxHeight)
                currHeight1 = e[1];
            currArea1 = currWidth1 * currHeight1;
            
            int currArea2 = 0;
            int currWidth2 = maxWidth;
            int currHeight2 = maxHeight;
            if(e[1] > maxWidth)
                currWidth2 = e[1];
            if(e[0] > maxHeight)
                currHeight2 = e[0];
            currArea2 = currWidth2 * currHeight2;
            
            if(currArea1 <= currArea2) {
                maxWidth = currWidth1;
                maxHeight = currHeight1;
            }
            else {
                maxWidth = currWidth2;
                maxHeight = currHeight2;
            }
        }
        return maxWidth * maxHeight;
    }
}
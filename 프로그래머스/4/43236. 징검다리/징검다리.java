import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        return ps(distance, rocks, n);
    }
    
    public static boolean determine(int dist, int[] sortedRocks, int endPos, int n) {
        int cnt=0;
        
        int postPos = 0;
        for(int i=0; i<sortedRocks.length; i++) {
            int currDist = sortedRocks[i] - postPos;
            if(currDist < dist) {
                cnt++;
            }
            else
                postPos = sortedRocks[i];
        }
        
        if(endPos - postPos < dist)
            cnt++;
        
        if(cnt <= n)
            return true;
        else
            return false;
    }
    
    public static int ps(int distance, int[] sortedRocks, int n) {
        int left = 0;
        int right = distance;
        
        while(left < right) {
            int mid = left + (right - left + 1)/2;
            
            if(determine(mid, sortedRocks, distance, n)) {
                left = mid;
            }
            else
                right = mid-1;
        }
        
        return left;
    }
}
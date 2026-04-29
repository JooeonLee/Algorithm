import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 0;
        long right = (long) times[times.length - 1] * n;
        long answer = 0;
        
        while(left <= right) {
            long mid = left + (right - left)/2;
            if(canProcess(times, n, mid)) {
                answer = mid;
                right = mid -1;
            } else
                left = mid + 1;
        }
        
        return answer;
    }
    
    boolean canProcess(int[] times, int n, long mid) {
        long count = 0;
        
        for(int t : times) {
            count += mid / t;
            
            if(count >= n)
                return true;
        }
        
        return count >= n;
    }
}
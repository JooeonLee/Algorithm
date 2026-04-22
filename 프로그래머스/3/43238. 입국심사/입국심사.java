class Solution {
    public long solution(int n, int[] times) {
        return bSearch(n, times);
    }
    
    public static boolean determine(int n, long currTime, int[] times) {
        long cnt = 0;
        for(int time : times)
            cnt += currTime / time;
        
        if(cnt >= n)
            return true;
        else
            return false;
    }
    
    public static long bSearch(int n, int[] times) {
        long mid = 0;
        long left = 0;
        long right = 1000000000000000000L;
        
        while(left < right) {
            mid = (left + right) / 2;
            
            if(determine(n, mid, times)) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}
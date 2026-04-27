import java.util.*;

class Solution {
    public int solution(int n) {
        int mid = (int)Math.sqrt(n);
        
        for(int i=0; i<=mid; i++) {
            if(n /mid == mid && n % mid == 0)
                return 1;
            else
                continue;
        }
        return 2;
    }
}
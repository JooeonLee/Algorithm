import java.util.*;

class Solution {
    public int solution(int n) {
        int cnt = 0;
        
        for(int i=2; i<=n; i++)
            if(isPrime(i))
                cnt++;
        
        
        return n-cnt-1;
    }
    
    public boolean isPrime(int num) {
        for(int i=2; i<=Math.sqrt(num); i++)
            if(num % i == 0)
                return false;
        
        return true;
    }
}
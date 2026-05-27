import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] check = new int[n+1];
        Arrays.fill(check, 1);
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int idx : lost)
            check[idx]--;
        
        for(int idx : reserve)
            check[idx]++;
        
        for(int i=0; i<lost.length; i++) {
            int idx = lost[i];
            
            if(check[idx] >= 1)
                continue;
            
            if(idx-1 >= 1 && check[idx-1] > 1) {
                check[idx-1]--;
                check[idx]++;
            }
            else if(idx+1 <= n && check[idx+1] > 1) {
                check[idx+1]--;
                check[idx]++;
            }
        }
        
        for(int c : check) {
            if(c >= 1)
                answer++;
        }
        
        return answer-1;
    }
}
import java.util.*;
import java.util.*;

class Solution {
    private int max = 0;
    private boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(0, k, dungeons);
        
        return max;
    }
    
    public void dfs(int cnt, int k, int[][] dungeons) {
        max = Math.max(max, cnt);
        
        for(int i=0; i<dungeons.length; i++) {
            int need = dungeons[i][0];
            int cost = dungeons[i][1];
            
            if(k >= need && !visited[i]) {
                visited[i] = true;
                
                dfs(cnt+1, k-cost, dungeons);
                
                visited[i] = false;
            }
        }
    }
}
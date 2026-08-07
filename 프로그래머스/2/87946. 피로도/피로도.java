import java.util.*;

class Solution {
    int max = 0;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return max;
    }
    
    private void dfs(int cnt, int k, int[][] dungeons) {
        max = Math.max(max, cnt);
        
        for(int i=0; i<dungeons.length; i++) {
            int need = dungeons[i][0];
            int cost = dungeons[i][1];
            
            if(!visited[i] && k >= need) {
                visited[i] = true;
                dfs(cnt+1, k-cost, dungeons);
                visited[i] = false;
            }
        }
    }
}


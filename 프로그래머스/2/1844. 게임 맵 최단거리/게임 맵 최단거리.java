import java.util.*;

class Solution {
    
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] dist = new int[n][m];
        dist[0][0] = 1;
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.add(new int[]{0,0});
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            int x = cur[0];
            int y = cur[1];
            
            if(x == n-1 && y == m-1)
                return dist[x][y];
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(!(nx>=0 && nx<n && ny>=0 && ny<m))
                    continue;
                if(maps[nx][ny] == 0)
                    continue;
                if(dist[nx][ny] != 0)
                    continue;
                
                dist[nx][ny] = dist[x][y] + 1;
                queue.add(new int[]{nx,ny});
            }
        }
        
        return -1;
    }
}
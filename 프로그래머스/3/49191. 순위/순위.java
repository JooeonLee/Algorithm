import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n][n];
        for(int[] arr : graph)
            Arrays.fill(arr, Integer.MAX_VALUE);
        for(int i=0; i<n; i++)
            graph[i][i] = 0;
        
        for(int[] edge : results) {
            int startIdx = edge[0] - 1;
            int endIdx = edge[1] - 1;
            
            graph[startIdx][endIdx] = 1;
        }
        
        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(graph[i][k] == 1 && graph[k][j] == 1)
                        graph[i][j] = 1; 
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            boolean flag = true;
            for(int j=0; j<n; j++) {
                if(graph[i][j] == Integer.MAX_VALUE && graph[j][i] == Integer.MAX_VALUE) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                answer++;
        }
        return answer;
    }
}
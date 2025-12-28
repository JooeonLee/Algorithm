import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int networks = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                networks++;
                bfs(i, n, computers, visited);
            }
        }

        return networks;
    }
    
    private void bfs(int start, int n, int[][] computers, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next = 0; next < n; next++) {
                if (!visited[next] && computers[cur][next] == 1) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}
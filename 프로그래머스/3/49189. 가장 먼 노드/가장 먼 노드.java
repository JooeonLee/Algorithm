import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] currEdge : edge) {
            graph.get(currEdge[0]).add(currEdge[1]);
            graph.get(currEdge[1]).add(currEdge[0]);
        }
        
        return maxDistByBfs(1, n, graph);
    }
    
    private int maxDistByBfs(int start, int n, List<List<Integer>> graph) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.add(new int[] {start, 0});
        dist[start] = 0;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            for(int next : graph.get(curr[0])) {
                if(dist[next] == -1) {
                    queue.add(new int[] {next, curr[1]+1});
                    dist[next] = curr[1]+1;
                }
            }
        }
        
        int maxDist = -1;
        for(int currDist : dist) {
            maxDist = Math.max(maxDist, currDist);
        }
        int count = 0;
        for(int currDist : dist) {
            if(currDist == maxDist)
                count++;
        }
        
        return count;
    }
}
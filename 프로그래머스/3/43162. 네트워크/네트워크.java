import java.util.*;

class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        visited = new boolean[n+1];
        
        for(int i=0; i<=computers.length; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(computers[i][j] == 1) {
                    graph.get(i+1).add(j+1);
                    graph.get(j+1).add(i+1);
                }
            }
        }
        
        
        int cnt = 0;
        for(int i=1; i<=n; i++) {
            if(!visited[i]) {
                cnt++;
                dfs(i, graph);
            }
        }
        
        return cnt;
    }
    
    private void dfs(int node, ArrayList<ArrayList<Integer>> graph) {
        visited[node] = true;
        
        for(int nextNode : graph.get(node)) {
            if(!visited[nextNode])
                dfs(nextNode, graph);
        }
    }
}
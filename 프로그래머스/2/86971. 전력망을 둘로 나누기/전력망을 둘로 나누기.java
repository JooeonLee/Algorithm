import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        for(int i=0; i<n-1; i++) {
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for(int j=0; j<=n; j++)
                graph.add(new ArrayList<>());
            
            for(int j=0; j<n-1; j++) {
                if(i == j)
                    continue;
                int from = wires[j][0];
                int to = wires[j][1];
                
                graph.get(from).add(to);
                graph.get(to).add(from);
            }
            
            boolean[] visited = new boolean[n+1];
            
            int currCnt = dfs(1, visited, graph);
            int otherCnt = n - currCnt;
            int currDiff = Math.abs(currCnt - otherCnt);
            
            answer = answer > currDiff ? currDiff : answer;
        }
        
        return answer;
    }
    
    public int dfs(int currNode, boolean[] visited, ArrayList<ArrayList<Integer>> graph) {
        int cnt = 1;
        visited[currNode] = true;
        ArrayList<Integer> curr = graph.get(currNode);
        
        for(int next : curr) {
            if(!visited[next]) {
                cnt += dfs(next, visited, graph);
            }
        }
        return cnt;
    }
}
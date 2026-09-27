import java.util.*;

/**
edge 정의해서 bfs하면 될 것 같기도?
visited 처리 어떻게 하지? 일단 계속 인자로 넘겨볼까?

*/
class Solution {
    static int maxCnt = -1;
    ArrayList<Edge>[] graph;
    
    static class Edge {
        int from;
        int to;
        int type;
        
        public Edge(int from, int to, int type) {
            this.from = from;
            this.to = to;
            this.type = type;
        }
    }
    
    static class State {
        int deepth;
        int[] visited;
        
        public State(int deepth, int[] visited) {
            this.deepth = deepth;
            this.visited = visited;
        }
    }
    
    public void dfs(int deepth, int[] visited, int k) {
        if(deepth == k) {
            int cnt = 0;
            for(int i=1; i<visited.length; i++)
                if(visited[i] == 1)
                    cnt++;
            
            maxCnt = Math.max(maxCnt, cnt);
            return;
        }
        
        State currState = new State(deepth, visited);
        
        for(int i=1; i<=3; i++) {
            // 1 type 선택
            int[] nextVisited1 = bfs(1, currState);
            dfs(deepth+1, nextVisited1, k);
            
            // 2 type 선택
            int[] nextVisited2 = bfs(2, currState);
            dfs(deepth+1, nextVisited2, k);
            
            // 3 type 선택
            int[] nextVisited3 = bfs(3, currState);
            dfs(deepth+1, nextVisited3, k);
        }
    }
    
    public int[] bfs(int type, State state) {
        int[] visited = state.visited.clone();
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i=1; i<visited.length; i++) {
            if(visited[i] == 1)
                queue.add(i);
        }
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            
            for(Edge e : graph[curr]) {
                if(e.type == type && visited[e.to] == 0) {
                    visited[e.to] = 1;
                    queue.add(e.to);
                }
            }
        }
        
        return visited;
    }
    
    public int solution(int n, int infection, int[][] edges, int k) {
        int answer = 0;
        graph = new ArrayList[n+1];
        int[] visited = new int[n+1];
        visited[infection] = 1;
        for(int i=0; i<n+1; i++)
            graph[i] = new ArrayList<>();
        
        for(int[] e : edges) {
            Edge edge1 = new Edge(e[0], e[1], e[2]);
            Edge edge2 = new Edge(e[1], e[0], e[2]);
            
            graph[e[0]].add(edge1);
            graph[e[1]].add(edge2);
        }
        
        dfs(0, visited, k);
        
        
        return maxCnt;
    }
}
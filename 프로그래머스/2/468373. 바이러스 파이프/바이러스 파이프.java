import java.util.*;

/**
edge 정의해서 bfs하면 될 것 같기도?
visited 처리 어떻게 하지? 일단 계속 인자로 넘겨볼까?

*/
class Solution {
    static int maxCnt = -1;
    ArrayList<Edge>[] graph;
    
    static class Edge {
        int to;
        int type;
        
        public Edge(int to, int type) {
            this.to = to;
            this.type = type;
        }
    }
    
    static class State {
        int depth;
        int[] visited;
        
        public State(int depth, int[] visited) {
            this.depth = depth;
            this.visited = visited;
        }
    }
    
    // 상태 공간 탐색 위한 dfs
    public void dfs(State s, int k) {
        if(s.depth == k) {
            int cnt = 0;
            for(int i=1; i<s.visited.length; i++)
                if(s.visited[i] == 1)
                    cnt++;
            
            maxCnt = Math.max(maxCnt, cnt);
            return;
        }
        
        for(int i=1; i<=3; i++) {
            // i type 선택
            int[] next = s.visited.clone();
            bfs(i, next);
            State nextS = new State(s.depth + 1, next);
            dfs(nextS, k);
        }
    }
    
    // State와 연 파이프 타입이 주어졌을 때 얼마나 퍼지는지 구하는 함수
    public void bfs(int type, int[] visited) {
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
        
        return;
    }
    
    public int solution(int n, int infection, int[][] edges, int k) {
        graph = new ArrayList[n+1];
        int[] visited = new int[n+1];
        visited[infection] = 1;
        for(int i=0; i<n+1; i++)
            graph[i] = new ArrayList<>();
        
        for(int[] e : edges) {
            Edge edge1 = new Edge(e[1], e[2]);
            Edge edge2 = new Edge(e[0], e[2]);
            
            graph[e[0]].add(edge1);
            graph[e[1]].add(edge2);
        }
        
        State s = new State(0, visited);
        dfs(s, k);
        
        
        return maxCnt;
    }
}
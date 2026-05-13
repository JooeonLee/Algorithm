class Solution {
    int n;
    int[][] computers;
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        this.visited = new boolean[n];
        
        int answer = 0;
        
        for(int i=0; i<n; i++) {
            if(this.visited[i] == false) {
                answer++;
                dfs(i);
            }
        }
        
        return answer;
    }
    
    public void dfs(int node) {
        if(this.visited[node] == true)
            return;
        
        this.visited[node] = true;
        
        for(int i=0; i<this.n; i++) {
            if(computers[node][i] == 1)
                dfs(i);
        }
    }
}
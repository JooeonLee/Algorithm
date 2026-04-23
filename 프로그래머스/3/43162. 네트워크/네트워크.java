class Solution {
    public int solution(int n, int[][] computers) {
        int[] visited = new int[n];
        int answer = 0;
        
        for(int i=0; i<n; i++) {
            if(visited[i] == 0) {
                answer++;
                dfs(i, n, computers, visited);
            }
        }
            
        return answer;
    }
    
    public void dfs(int currNode, int n, int[][] computers, int[] visited) {
        visited[currNode] = 1;
        for(int i=0; i<n; i++) {
            if(computers[currNode][i] == 1) {
                if(visited[i] == 0) {
                    visited[i] = 1;
                    dfs(i, n, computers, visited);
                }    
            }    
        }
        return;
    }
}
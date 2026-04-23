class Solution {
    static int cnt = 0;
    public static int solution(int[] numbers, int target) {
        int[] visited = new int[numbers.length];
        
        dfs(0, 0, visited, numbers, target);
        
        return cnt;
    }
    
    public static void dfs(int currResult, int currIdx, int[] visited, int[] numbers, int target) {
        if(currResult == target && currIdx == visited.length) {
            cnt++;
            return;
        }
        else if(currIdx == visited.length) {
            return;
        } 
        else {
            for(int i=1; i<=2; i++) {
                int flag=1;
                if(i==1)
                    flag=1;
                else
                    flag=-1;
                
                visited[currIdx] = 1;
                int nextResult = currResult + numbers[currIdx] * flag;
                dfs(nextResult, currIdx+1, visited, numbers, target);
                visited[currIdx] = 0;   
            }
        }
    }
}
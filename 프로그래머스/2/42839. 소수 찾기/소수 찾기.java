import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        
        boolean[] visited = new boolean[numbers.length()];
        Set<Integer> result = new HashSet<>();
        dfs(numbers, 0, visited, result);
        
        List<Integer> numArr = result.stream()
            .toList();
        for(Integer num : numArr)
            if(isPrimeNum(num))
                answer++;
        
        return answer;
    }
    
    private void dfs(String numbers,
                    int currNum,
                    boolean[] visited,
                    Set<Integer> result) {
        
        for(int i=0; i<numbers.length(); i++) {
            if(visited[i])
                continue;
            
            visited[i] = true;
            
            int nextNum = currNum * 10 + (numbers.charAt(i) - '0');
            result.add(nextNum);
            dfs(numbers, nextNum, visited, result);
            
            visited[i] = false;
        }
    }
    
    private boolean isPrimeNum(int num) {
        if(num < 2)
            return false;
        
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
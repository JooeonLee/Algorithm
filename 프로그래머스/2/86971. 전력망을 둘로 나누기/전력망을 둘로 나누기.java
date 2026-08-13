import java.util.*;

class Solution {
    boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = n;
        visited = new boolean[n+1];
        
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for(int i=0; i<n+1; i++)
            tree.add(new ArrayList<>());
        
        for(int i=0; i<n-1; i++) {
            int[] edge = wires[i];
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        
        for(int i=0; i<n-1; i++) {
            int[] removeEdge = wires[i];
            tree.get(removeEdge[0]).remove(Integer.valueOf(removeEdge[1]));
            tree.get(removeEdge[1]).remove(Integer.valueOf(removeEdge[0]));
            
            Arrays.fill(visited, false);
            dfs(removeEdge[0], tree);
            int comp1 = 0;
            int comp2 = 0;
            int currDiff = 0;
            
            for(int j=1; j<n+1; j++)
                if(visited[j])
                    comp1++;
            comp2 = n - comp1;
            currDiff = Math.abs(comp1 - comp2);
            answer = Math.min(answer, currDiff);
            
            tree.get(removeEdge[0]).add(removeEdge[1]);
            tree.get(removeEdge[1]).add(removeEdge[0]);
        }
        return answer;
    }
    
    void dfs(int idx, ArrayList<ArrayList<Integer>> tree) {
        visited[idx] = true;
        
        ArrayList<Integer> connected = tree.get(idx);
        for(int nextIdx : connected) {
            if(!visited[nextIdx])
                dfs(nextIdx, tree);
        }
    }
}

/**
2 <= n <= 100
입력이 반드시 트리로 주어진다
*/
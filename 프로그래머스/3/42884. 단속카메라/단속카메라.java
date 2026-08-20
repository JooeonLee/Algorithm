import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Set<Integer> cctvSet = new HashSet<>();
        
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        int cnt = 0;
        int resentCctv = -1;
        for(int[] route : routes) {
            if(cctvSet.contains(route[1]))
                continue;
            else if(resentCctv >= route[0] && resentCctv <= route[1])
                continue;
            else {
                cctvSet.add(route[1]);
                resentCctv = route[1];
            }
        }
        return cctvSet.size();
    }
}
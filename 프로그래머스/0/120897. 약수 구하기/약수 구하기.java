import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=1; i<=n; i++)
            if(n % i == 0)
                arr.add(i);
        
        return arr.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
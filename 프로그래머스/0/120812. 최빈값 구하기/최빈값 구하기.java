import java.util.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<array.length; i++) {
            int num = array[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int max = map.values().stream().mapToInt(Integer::intValue).max().orElse(0);
        int cnt = 0;
        int answer = 0;
        for(int key : map.keySet()) {
            if(max == map.get(key)) {
                answer = key;
                cnt++;
            }
        }
        
        if(cnt == 1)
            return answer;
        else
            return -1;
    }
}
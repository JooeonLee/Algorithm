import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : numbers)
            maxPq.add(i);
        
        int max = maxPq.poll();
        int nextMax = maxPq.poll();
        
        return max * nextMax;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        int maxResult = 1;
        int minResult = 1;
        
        for(int num : numbers) {
            maxPq.offer(num);
            minPq.offer(num);
        }
        
        maxResult *= maxPq.poll();
        maxResult *= maxPq.poll();
        
        minResult *= minPq.poll();
        minResult *= minPq.poll();
        
        int result = maxResult > minResult ? maxResult : minResult;

        return result;
    }
}
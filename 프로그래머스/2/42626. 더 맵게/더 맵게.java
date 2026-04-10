import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for (int s : scoville) {
            pq.offer((long) s);
        }
        
        int count = 0;
        
        while (!pq.isEmpty() && pq.peek() < K) {
            if (pq.size() < 2) {
                return -1;
            }
            
            long first = pq.poll();
            long second = pq.poll();
            long mixed = first + (second * 2);
            
            pq.offer(mixed);
            count++;
        }
        
        return count;
    }
}
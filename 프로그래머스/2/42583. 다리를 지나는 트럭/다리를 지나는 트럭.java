import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0; i<bridge_length; i++)
            deque.offer(0);
        
        int idx = 0;
        int time = 0;
        int remainWeight = weight;
        while(!deque.isEmpty() && idx < truck_weights.length) {
            time++;
            int outWeight = deque.pollLast();
            remainWeight += outWeight;
            
            if(remainWeight >= truck_weights[idx]) {
                deque.offerFirst(truck_weights[idx]);
                remainWeight -= truck_weights[idx];
                idx++;
            }
            else {
                deque.offerFirst(0);
            }
        }
        
        while(!deque.isEmpty()) {
            time++;
            deque.pollLast();
        }
        return time;
    }
}
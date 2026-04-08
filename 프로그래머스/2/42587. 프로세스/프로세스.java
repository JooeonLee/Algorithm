import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Pair> queue = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++) {
            Pair curr = new Pair(i, priorities[i]);
            queue.offer(curr);
        }
        
        int[] order = new int[priorities.length];
        int idx = 0;
        
        while(!queue.isEmpty()) {
            Pair curr = queue.poll();
            boolean hasHigherPriority = false;
            for(Pair p : queue) {
                if(p.priority > curr.priority) {
                    hasHigherPriority = true;
                    break;
                }
            }
            if(hasHigherPriority)
                queue.add(curr);
            else
                order[idx++] = curr.idx;
        }
        
        int answer = -1;
        
        for(int i=0; i<order.length; i++) {
            if(order[i] == location)
                answer = i+1;
        }
        
        return answer;
    }
    
    class Pair {
        int idx;
        int priority;
        
        public Pair(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    } 
}
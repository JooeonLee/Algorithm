import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{priorities[i], i == location ? 1 : 0});
        }
        
        int order = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            boolean hasHigherPriority = false;

            for (int[] q : queue) {
                if (q[0] > current[0]) {
                    hasHigherPriority = true;
                    break;
                }
            }

            if (hasHigherPriority) {
                queue.offer(current);
            } else {
                order++;
                if (current[1] == 1) {
                    return order;
                }
            }
        }

        return order;
    }
}

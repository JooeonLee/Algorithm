import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        
        // 큐 초기화: [우선순위, 내가 찾는 프로세스 여부]
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{priorities[i], i == location ? 1 : 0});
        }
        
        int order = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            boolean hasHigherPriority = false;

            // 큐에 더 높은 우선순위가 있는지 확인
            for (int[] q : queue) {
                if (q[0] > current[0]) {
                    hasHigherPriority = true;
                    break;
                }
            }

            if (hasHigherPriority) {
                // 다시 큐 뒤로
                queue.offer(current);
            } else {
                // 실행
                order++;
                if (current[1] == 1) {
                    return order;
                }
            }
        }

        return order;
    }
}

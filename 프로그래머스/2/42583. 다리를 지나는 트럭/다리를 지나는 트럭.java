import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        
        // 다리를 처음엔 빈 상태로 채움
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        int time = 0;
        int currentWeight = 0;
        int truckIndex = 0;

        while (truckIndex < truck_weights.length) {
            time++;

            // 1. 다리에서 한 칸 이동 (트럭 내려감)
            currentWeight -= bridge.poll();

            // 2. 다음 트럭을 올릴 수 있는지 확인
            if (currentWeight + truck_weights[truckIndex] <= weight) {
                bridge.offer(truck_weights[truckIndex]);
                currentWeight += truck_weights[truckIndex];
                truckIndex++;
            } else {
                bridge.offer(0); // 못 올라가면 빈 공간
            }
        }

        // 마지막 트럭이 다리를 완전히 건너는 시간
        time += bridge_length;

        return time;
    }
}

import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        Map<Integer, Integer> idxMap = new HashMap<>();

        for (int i = 0; i < emergency.length; i++) {
            idxMap.put(emergency[i], i);
        }

        Arrays.sort(emergency);

        int[] answer = new int[emergency.length];
        int rank = 1;

        for (int i = emergency.length - 1; i >= 0; i--) {
            int originalIndex = idxMap.get(emergency[i]);
            answer[originalIndex] = rank++;
        }

        return answer;
    }
}
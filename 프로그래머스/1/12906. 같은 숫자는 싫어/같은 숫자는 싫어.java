import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> result = new ArrayList<>();

        int prev = -1; // arr 원소는 0~9이므로 -1로 초기화

        for (int num : arr) {
            if (num != prev) {
                result.add(num);
                prev = num;
            }
        }

        // List -> int[]
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}

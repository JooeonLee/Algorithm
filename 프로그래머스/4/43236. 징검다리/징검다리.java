import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int left = 1;          // 가능한 최소 거리(하한)
        int right = distance;  // 가능한 최소 거리(상한)
        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2; // "최소 거리"를 mid 이상으로 만들 수 있나?
            if (canKeepMinDistance(distance, rocks, n, mid)) {
                answer = mid;      // 가능하면 더 키워본다
                left = mid + 1;
            } else {
                right = mid - 1;   // 불가능하면 줄인다
            }
        }
        return answer;
    }

    // minDist를 만족하려면 제거해야 하는 바위 개수가 n 이하인지 체크
    private boolean canKeepMinDistance(int distance, int[] rocks, int n, int minDist) {
        int removed = 0;
        int prev = 0; // 출발점(0)

        for (int r : rocks) {
            if (r - prev < minDist) {
                removed++; // 너무 가까우니 현재 바위를 제거
                if (removed > n) return false;
            } else {
                prev = r; // 유지
            }
        }

        // 마지막(도착점) 간격 체크
        if (distance - prev < minDist) removed++;

        return removed <= n;
    }
}

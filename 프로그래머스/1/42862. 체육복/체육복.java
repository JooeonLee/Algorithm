import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 정렬 (앞번호부터 처리하기 위함)
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 체육복 상태 배열 (1-based index)
        int[] clothes = new int[n + 1];
        Arrays.fill(clothes, 1);

        // 도난
        for (int l : lost) {
            clothes[l]--;
        }

        // 여벌
        for (int r : reserve) {
            clothes[r]++;
        }

        // 빌려주기 (그리디)
        for (int i = 1; i <= n; i++) {
            if (clothes[i] == 0) {
                // 앞 학생에게 빌리기
                if (i - 1 >= 1 && clothes[i - 1] == 2) {
                    clothes[i - 1]--;
                    clothes[i]++;
                }
                // 뒷 학생에게 빌리기
                else if (i + 1 <= n && clothes[i + 1] == 2) {
                    clothes[i + 1]--;
                    clothes[i]++;
                }
            }
        }

        // 체육수업 가능한 학생 수 계산
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (clothes[i] >= 1) {
                answer++;
            }
        }

        return answer;
    }
}

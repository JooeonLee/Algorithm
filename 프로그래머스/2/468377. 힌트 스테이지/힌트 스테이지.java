import java.util.*;

class Solution {

    int[][] cost;
    int[][] hint;

    int L;
    int answer;

    int[] hintCnt;
    int[][] given;

    public int solution(int[][] cost, int[][] hint) {

        answer = Integer.MAX_VALUE;

        this.cost = cost;
        this.hint = hint;

        L = cost.length;

        hintCnt = new int[L];
        given = new int[hint.length][L];

        // 각 힌트 번들이 각 스테이지에 몇 개의 힌트를 주는지 계산
        for (int i = 0; i < hint.length; i++) {
            for (int j = 1; j < hint[i].length; j++) {
                int stage = hint[i][j] - 1;
                given[i][stage]++;
            }
        }

        dfs(0, 0);

        return answer;
    }

    private void dfs(int depth, int totalCost) {
        // 모든 힌트 번들의 구매 여부를 결정함
        if (depth == hint.length) {
            int value = totalCost;
            for (int stage = 0; stage < L; stage++) {
                int cnt = Math.min(
                    L - 1,
                    hintCnt[stage]
                );
                value += cost[stage][cnt];
            }
            answer = Math.min(answer, value);

            return;
        }

        // 현재 힌트 번들 구매 X
        dfs(depth + 1, totalCost);

        // 현재 힌트 번들 구매 O
        for (int stage = 0; stage < L; stage++) {
            hintCnt[stage] += given[depth][stage];
        }

        dfs(depth + 1, totalCost + hint[depth][0]);

        // 상태 원상복구
        for (int stage = 0; stage < L; stage++) {
            hintCnt[stage] -= given[depth][stage];
        }
    }
}
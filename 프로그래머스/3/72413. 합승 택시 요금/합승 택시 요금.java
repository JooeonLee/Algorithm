import java.util.*;

class Solution {
    static final int INF = 1_000_000_000;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];

            dist[from][to] = cost;
            dist[to][from] = cost;
        }

        // 플로이드–워셜
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(
                        dist[i][j],
                        dist[i][k] + dist[k][j]
                    );
                }
            }
        }

        int answer = INF;

        for (int k = 1; k <= n; k++) {
            if (dist[s][k] == INF || dist[k][a] == INF || dist[k][b] == INF)
                continue;

            answer = Math.min(
                answer,
                dist[s][k] + dist[k][a] + dist[k][b]
            );
        }

        return answer;
    }
}
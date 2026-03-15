import java.io.*;
import java.util.*;

public class Main {

    static final int INF = 1_000_000;

    public static void main(String[] args) {
        FastReader fr = new FastReader();

        int n = fr.nextInt();
        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        while (true) {
            int a = fr.nextInt();
            int b = fr.nextInt();

            if (a == -1 && b == -1) {
                break;
            }

            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int minScore = INF;
        int[] score = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int maxDist = 0;
            for (int j = 1; j <= n; j++) {
                maxDist = Math.max(maxDist, dist[i][j]);
            }
            score[i] = maxDist;
            minScore = Math.min(minScore, maxDist);
        }

        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (score[i] == minScore) {
                candidates.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(minScore).append(" ").append(candidates.size()).append("\n");
        for (int candidate : candidates) {
            sb.append(candidate).append(" ");
        }

        System.out.println(sb);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static final long MIN = Long.MIN_VALUE;

    static int n, k;
    static long[] value;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        n = fr.nextInt();
        graph = new ArrayList<>(n + 1);
        value = new long[n + 1];

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++) {
            int a = fr.nextInt();
            int b = fr.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int u = 1; u <= n; u++) {
            value[u] = fr.nextLong();
        }

        k = Math.min(n, fr.nextInt());

        long[][] rootDp = dfs(1, 0);

        long answer = 0;
        for(int count = 0; count < rootDp[0].length; count++) {
            answer = Math.max(answer, rootDp[0][count]);
            answer = Math.max(answer, rootDp[1][count]);
        }

        System.out.println(answer);
    }

    // dp[색칠 여부][고른 개수]
    static long[][] dfs(int u, int parent) {
        int limit = Math.min(1, k);
        long[][] dp = new long[2][limit + 1];

        Arrays.fill(dp[0], MIN);
        Arrays.fill(dp[1], MIN);

        dp[0][0] = 0;
        if(k > 0)
            dp[1][1] = value[u];

        for(int v : graph.get(u)) {
            if(v == parent)
                continue;

            long[][] child = dfs(v, u);
            int childLimit = child[0].length - 1;
            int nextLimit = Math.min(k, limit + childLimit);

            long[][] next = new long[2][nextLimit + 1];
            Arrays.fill(next[0], MIN);
            Arrays.fill(next[1], MIN);

            // 지금까지 합친 쪽에서 i개, 자식 v 쪽에서 j개를 고름
            for(int i = 0; i <= limit; i++) {
                int maxJ = Math.min(childLimit, k-i);

                for(int j = 0; j <= maxJ; j++) {
                    long childSkip = child[0][j];
                    long childBest = Math.max(childSkip, child[1][j]);

                    // u를 안 칠하면 v를 칠해도 됨
                    if(dp[0][i] != MIN && childBest != MIN)
                        next[0][i + j] = Math.max(next[0][i + j], dp[0][i]+childBest);

                    // u를 칠하면 v는 건너뜀 v의 자손은 고를 수 있음
                    if(dp[1][i] != MIN && childSkip != MIN) {
                        next[1][i + j] = Math.max(
                            next[1][i + j], dp[1][i] + childSkip
                        );
                    }
                }
            }

            dp = next;
            limit = nextLimit;
        }

        return dp;
    }

    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while(st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}
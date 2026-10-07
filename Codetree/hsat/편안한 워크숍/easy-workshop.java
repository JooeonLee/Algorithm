import java.util.*;
import java.io.*;

class Position implements Comparable<Position> {
    int r, c, k, max;

    Position(int r, int c, int k, int max) {
        this.r = r;
        this.c = c;
        this.k = k;
        this.max = max;
    }

    @Override
    public int compareTo(Position o) {
        if (this.max != o.max)
            return Integer.compare(this.max, o.max);

        return Integer.compare(o.k, this.k);
    }
}

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int N, K;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                grid[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dijkstra());
    }

    static int dijkstra() {
        if (K > N * N) return -1;

        PriorityQueue<Position> pq = new PriorityQueue<>();

        // dp[r][c][k] = k번 이동해 도착했을 때 최소 bottleneck
        int[][][] dp = new int[N][N][K];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                Arrays.fill(dp[r][c], INF);

                dp[r][c][0] = 0;
                pq.offer(new Position(r, c, 0, 0));
            }
        }

        while (!pq.isEmpty()) {
            Position cur = pq.poll();

            if (cur.max != dp[cur.r][cur.c][cur.k])
                continue;

            if (cur.k == K - 1)
                return cur.max;

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N)
                    continue;

                if (grid[nr][nc] <= grid[cur.r][cur.c])
                    continue;

                int diff = grid[nr][nc] - grid[cur.r][cur.c];
                int nextMax = Math.max(cur.max, diff);
                int nextK = cur.k + 1;

                if (dp[nr][nc][nextK] <= nextMax)
                    continue;

                dp[nr][nc][nextK] = nextMax;
                pq.offer(new Position(nr, nc, nextK, nextMax));
            }
        }

        return -1;
    }
}
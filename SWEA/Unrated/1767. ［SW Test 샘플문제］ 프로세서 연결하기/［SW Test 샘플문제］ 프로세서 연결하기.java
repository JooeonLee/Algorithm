import java.util.*;
import java.io.*;

public class Solution {

    static int N;
    static int[][] map;

    static ArrayList<int[]> cores;

    static int maxCore;
    static int minLength;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        StringBuilder sb = new StringBuilder();

        int T = fr.nextInt();

        for (int t = 1; t <= T; t++) {
            N = fr.nextInt();

            map = new int[N][N];
            cores = new ArrayList<>();

            maxCore = 0;
            minLength = Integer.MAX_VALUE;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    map[r][c] = fr.nextInt();

                    if (map[r][c] == 1) {
                        if (r != 0 && r != N - 1 && c != 0 && c != N - 1) {
                            cores.add(new int[]{r, c});
                        }
                    }
                }
            }

            dfs(0, 0, 0);

            sb.append('#').append(t).append(' ').append(minLength).append('\n');
        }

        System.out.print(sb);
    }

    static void dfs(int idx, int connected, int length) {

        if (idx == cores.size()) {
            if (connected > maxCore) {
                maxCore = connected;
                minLength = length;
            } else if (connected == maxCore) {
                minLength = Math.min(minLength, length);
            }

            return;
        }

        int r = cores.get(idx)[0];
        int c = cores.get(idx)[1];

        for (int d = 0; d < 4; d++) {

            if (!canConnect(r, c, d))
                continue;

            int wireLength = setWire(r, c, d, 2);

            dfs(idx + 1, connected + 1, length + wireLength);

            setWire(r, c, d, 0);
        }

        dfs(idx + 1, connected, length);
    }

    static boolean canConnect(int r, int c, int d) {

        int nr = r + dr[d];
        int nc = c + dc[d];

        while (nr >= 0 && nr < N && nc >= 0 && nc < N) {

            if (map[nr][nc] != 0)
                return false;

            nr += dr[d];
            nc += dc[d];
        }

        return true;
    }

    static int setWire(int r, int c, int d, int value) {

        int nr = r + dr[d];
        int nc = c + dc[d];

        int count = 0;

        while (nr >= 0 && nr < N && nc >= 0 && nc < N) {

            map[nr][nc] = value;
            count++;

            nr += dr[d];
            nc += dc[d];
        }

        return count;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

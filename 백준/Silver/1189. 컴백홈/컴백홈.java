import java.io.*;
import java.util.*;

public class Main {

    static int R, C, K;
    static char[][] map;
    static boolean[][] visited;
    static int answer = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        FastReader fr = new FastReader();

        R = fr.nextInt();
        C = fr.nextInt();
        K = fr.nextInt();

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = fr.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);

        System.out.println(answer);
    }

    static void dfs(int x, int y, int dist) {
        if (x == 0 && y == C - 1) {
            if (dist == K) {
                answer++;
            }
            return;
        }

        if (dist >= K) {
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                continue;
            }

            if (visited[nx][ny] || map[nx][ny] == 'T') {
                continue;
            }

            visited[nx][ny] = true;
            dfs(nx, ny, dist + 1);
            visited[nx][ny] = false;
        }
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
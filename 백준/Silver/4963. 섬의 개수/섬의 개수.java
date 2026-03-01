import java.util.*;
import java.io.*;

public class Main {

    static final int[] dx = {-1, -1, -1,  0, 0, 1, 1, 1};
    static final int[] dy = {-1,  0,  1, -1, 1,-1, 0, 1};

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        StringBuilder sb = new StringBuilder();

        while (true) {
            int w = fr.nextInt();
            int h = fr.nextInt();
            if (w == 0 && h == 0) break;

            int[][] map = new int[h][w];
            boolean[][] visited = new boolean[h][w];

            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    map[y][x] = fr.nextInt();
                }
            }

            int islands = 0;
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    if (map[y][x] == 1 && !visited[y][x]) {
                        bfs(map, visited, w, h, x, y);
                        islands++;
                    }
                }
            }

            sb.append(islands).append('\n');
        }

        System.out.print(sb.toString());
    }

    static void bfs(int[][] map, boolean[][] visited, int w, int h, int sx, int sy) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[sy][sx] = true;
        q.add(new int[]{sx, sy});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int dir = 0; dir < 8; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= w || ny < 0 || ny >= h) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] == 0) continue;

                visited[ny][nx] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int M = fr.nextInt();
        int[][] city = new int[M][N];
        int[][] visited = new int[M][N];

        for(int y=0; y<M; y++) {
            for(int x=0; x<N; x++) {
                city[y][x] = fr.nextInt();
            }
        }

        boolean result = dfs(city, visited, N, M, 0, 0);
        System.out.println(result ? "Yes" : "No");

    }

    static boolean dfs(int[][] city, int[][] visited, int N, int M, int curX, int curY) {
        if(curX == N-1 && curY == M-1) 
            return true;

        visited[curY][curX] = 1;

        for(int dir=0; dir<2; dir++) {
            int nx = curX + dx[dir];
            int ny = curY + dy[dir];

            if(!isValid(N, M, nx, ny)) continue;
            if(city[ny][nx] == 0) continue;
            if(visited[ny][nx] == 1) continue;

            if(dfs(city, visited, N, M, nx, ny))
                return true;
        }
        
        return false;
    }

    static boolean isValid(int N, int M, int xIdx, int yIdx) {
        return xIdx >= 0 && xIdx < N && yIdx >= 0 && yIdx < M;
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

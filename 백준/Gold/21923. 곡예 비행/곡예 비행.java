import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        input();
        solution();
    }

    static FastReader scan = new FastReader();

    static int N, M;
    static int[][] grid;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                grid[i][j] = scan.nextInt();
            }
        }
    }

    static void solution() {

        // DP 테이블 초기화
        long [][] dpUp = new long[N][M];
        long [][] dpDown = new long[N][M];

        // dpUp 초기값 설정
        dpUp[N-1][0] = grid[N-1][0];
        for(int i = 1; i < M; i++) {
            dpUp[N-1][i] = dpUp[N-1][i-1] + grid[N-1][i];
        }
        for(int i = N-2; i >= 0; i--) {
            dpUp[i][0] = dpUp[i+1][0] + grid[i][0];
        }
        for(int i = N-2; i >= 0; i--) {
            for(int j = 1; j < M; j++) {
                dpUp[i][j] = Math.max(dpUp[i+1][j], dpUp[i][j-1]) + grid[i][j];
            }
        }

        // dpDown 초기값 설정
        dpDown[N-1][M-1] = grid[N-1][M-1];
        for(int i = M-2; i >= 0; i--) {
            dpDown[N-1][i] = dpDown[N-1][i+1] + grid[N-1][i];
        }
        for(int i = N-2; i >= 0; i--) {
            dpDown[i][M-1] = dpDown[i+1][M-1] + grid[i][M-1];
        }

        for(int i = N-2; i >= 0; i--) {
            for(int j = M-2; j >= 0; j--) {
                dpDown[i][j] = Math.max(dpDown[i][j+1], dpDown[i+1][j]) + grid[i][j];
            }
        }

        long answer = Long.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                answer = Math.max(answer, dpUp[i][j] + dpDown[i][j]);
            }
        }
        System.out.println(answer);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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

        long nextLong() {
            return Long.parseLong(next());
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        input();
        solution();
    }

    static FastReader scan = new FastReader();

    static void input() {
        N = scan.nextInt();
        S = new int[N][N];
        visited = new boolean[N];

        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++)
                S[i][j] = scan.nextInt();
        }
    }

    private static void calculateDiff() {
        int teamStart=0, teamLink=0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if (visited[i] && visited[j]) {
                    teamStart += S[i][j];
                }
                else if(!visited[i] && !visited[j]) {
                    teamLink += S[i][j];
                }
            }
        }
        minDiff = Math.min(minDiff, Math.abs(teamStart - teamLink));
    }

    private static void findMinDiff(int start, int depth, int teamSize) {
        if (depth == teamSize) {
            calculateDiff();
            return;
        }
        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                findMinDiff(i+1, depth + 1, teamSize);
                visited[i] = false;
            }
        }
    }

    static void solution() {
        for(int i=1; i<N; i++) {
            findMinDiff(0, 0, i);
        }
        System.out.println(minDiff);
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
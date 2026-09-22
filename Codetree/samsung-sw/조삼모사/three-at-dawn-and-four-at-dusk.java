import java.util.*;
import java.io.*;

public class Main {

    static int[][] map;
    static boolean[] visited;
    static int n;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {

        FastReader fr = new FastReader();

        n = fr.nextInt();

        map = new int[n][n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = fr.nextInt();
            }
        }

        dfs(0, 0);

        System.out.println(minDiff);
    }

    static void dfs(int currIdx, int selectedCnt) {

        if(selectedCnt == n / 2) {
            calculate();
            return;
        }

        for(int i = currIdx + 1; i < n; i++) {
            visited[i] = true;
            dfs(i, selectedCnt + 1);
            visited[i] = false;
        }
    }

    static void calculate() {

        int morning = 0;
        int evening = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {

                if(visited[i] && visited[j]) {
                    morning += map[i][j] + map[j][i];
                }
                else if(!visited[i] && !visited[j]) {
                    evening += map[i][j] + map[j][i];
                }
            }
        }

        int diff = Math.abs(morning - evening);
        minDiff = Math.min(minDiff, diff);
    }

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(Exception e) {
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        input();
        solution();
        System.out.println(diameter);
    }

    static FastReader scan = new FastReader();
    static List<List<int[]>> tree = new ArrayList<>();
    static boolean[] visited;
    static int N;
    static int diameter = 0;

    static void input() {
        N = scan.nextInt();
        visited = new boolean[N+1];
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < N-1; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            int w = scan.nextInt();

            tree.get(u).add(new int[]{v, w});
            tree.get(v).add(new int[]{u, w});
        }
    }

    static void solution() {
        for(int i = 1; i <= N; i++) {
            Arrays.fill(visited, false);
            dfs(i, 0);
        }
    }

    static void dfs(int v, int currentWeight) {
        visited[v] = true;
        diameter = Math.max(diameter, currentWeight);

        for (int[] next : tree.get(v)) {
            if (!visited[next[0]]) {
                dfs(next[0], currentWeight+next[1]);
            }
        }
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
    }
}
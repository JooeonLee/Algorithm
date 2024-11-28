import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        input();
        solution();
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<ArrayList<Integer>> tree;
    static boolean[] visited;
    static int[] parent;

    static void input() {
        N = scan.nextInt();
        tree = new ArrayList<>();
        for(int i = 0; i < N+1; i++) {
            tree.add(new ArrayList<>());
        }
        parent = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < N-1; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
    }

    static void solution() {
        dfs(1);
        for(int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }
    static void dfs(int parentNode) {
        visited[parentNode] = true;

        for (int childNode : tree.get(parentNode)) {
            if (!visited[childNode]) {
                parent[childNode] = parentNode;
                dfs(childNode);
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
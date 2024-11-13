import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        input();
        solution();
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] parent;

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        parent = new int[n+1];

        for(int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    static int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    static void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU != rootV) {
            parent[rootU] = rootV;
        }
    }

    static void solution() {

        for (int i = 0; i < m; i++) {
            int operation = scan.nextInt();
            int a = scan.nextInt();
            int b = scan.nextInt();

            if (operation == 0) { // 합집합 연산
                union(a, b);
            } else if (operation == 1) { // 같은 집합 여부 확인
                if (find(a) == find(b)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        System.out.print(sb.toString());
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
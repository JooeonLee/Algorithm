import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        input();
        topologicalSort();
        System.out.println(sb.toString());
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[][] adjMatrix;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        adjMatrix = new int[N+1][N+1];
        initAdjMatrix();
        for (int i = 0; i < M; i++) {
            int A = scan.nextInt();
            int B = scan.nextInt();
            adjMatrix[A][B] = 1;
        }
    }

    static void initAdjMatrix() {
        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < N+1; j++) {
                adjMatrix[i][j] = 0;
            }
        }
    }

    static void topologicalSort() {
        int[] indegree = new int[N+1];
        Arrays.fill(indegree, 0);
        int[] result = new int[N+1];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(adjMatrix[i][j] == 1) {
                    indegree[j]++;
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            if(indegree[i] == 0) {
                queue.add(new int[] {i, 1});
            }
        }

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            result[node[0]] = node[1];

            int count = node[1] + 1;
            for(int i = 1; i <= N; i++) {
                if(adjMatrix[node[0]][i] == 1) {
                    indegree[i]--;
                    if(indegree[i] == 0) {
                        queue.add(new int[] {i, count});
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            sb.append(result[i]).append(" ");
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
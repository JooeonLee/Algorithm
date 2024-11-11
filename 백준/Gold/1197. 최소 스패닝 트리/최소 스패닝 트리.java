import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        input();
        System.out.println(kruskal());
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int V, E;
    static int[] parent;
    static PriorityQueue<Edge> pq;

    static void input() {
        V = scan.nextInt();
        E = scan.nextInt();
        parent = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            parent[i] = i;
        }

        pq = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            int weight = scan.nextInt();
            
            pq.add(new Edge(u, v, weight));
        }
    }

    static long kruskal() {
        long mstWeight = 0;
        int edgesUsed = 0;

        while(!pq.isEmpty() && edgesUsed < V-1) {
            Edge edge = pq.poll();
            if (find(edge.u) != find(edge.v)) { // 사이클이 생기지 않는 경우만 추가
                union(edge.u, edge.v);
                mstWeight += edge.weight;
                edgesUsed++;
            }
        }
        return mstWeight;
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

    static class Edge implements Comparable<Edge> {
        int u, v, weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
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
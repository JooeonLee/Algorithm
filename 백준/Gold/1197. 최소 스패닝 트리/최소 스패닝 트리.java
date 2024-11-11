import java.io.*;
import java.util.*;

public class Main {
    static int V, E; // V: 정점 수, E: 간선 수
    static int[] parent;
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // Union-Find용 부모 배열 초기화
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        // 간선 정보를 우선순위 큐에 저장 (가중치가 작은 순으로 정렬됨)
        pq = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.add(new Edge(u, v, weight));
        }

        System.out.println(kruskal());
    }

    // 크루스칼 알고리즘을 이용해 최소 스패닝 트리의 가중치 합 계산
    static long kruskal() {
        long mstWeight = 0;
        int edgesUsed = 0;

        // 간선이 가중치 작은 순으로 정렬되어 있으므로, 작은 것부터 선택
        while (!pq.isEmpty() && edgesUsed < V - 1) {
            Edge edge = pq.poll();
            if (find(edge.u) != find(edge.v)) { // 사이클이 생기지 않는 경우만 추가
                union(edge.u, edge.v);
                mstWeight += edge.weight;
                edgesUsed++;
            }
        }

        return mstWeight;
    }

    // 유니온-파인드: find 연산 (경로 압축)
    static int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    // 유니온-파인드: union 연산
    static void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU != rootV) {
            parent[rootU] = rootV;
        }
    }

    // 간선 클래스 정의
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
}
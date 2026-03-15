import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        FastReader fr = new FastReader();

        int n = fr.nextInt();

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        while (true) {
            int a = fr.nextInt();
            int b = fr.nextInt();

            if (a == -1 && b == -1) {
                break;
            }

            graph[a].add(b);
            graph[b].add(a);
        }

        int[] scores = new int[n + 1];
        int minScore = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            scores[i] = bfs(i, graph, n);
            minScore = Math.min(minScore, scores[i]);
        }

        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (scores[i] == minScore) {
                candidates.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(minScore).append(" ").append(candidates.size()).append("\n");
        for (int candidate : candidates) {
            sb.append(candidate).append(" ");
        }

        System.out.println(sb);
    }

    static int bfs(int start, List<Integer>[] graph, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph[cur]) {
                if (dist[next] != -1) {
                    continue;
                }
                dist[next] = dist[cur] + 1;
                queue.offer(next);
            }
        }

        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            maxDist = Math.max(maxDist, dist[i]);
        }

        return maxDist;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
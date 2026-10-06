import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int K;

    static int answer = Integer.MAX_VALUE;

    // 색깔별 점 목록
    static ArrayList<int[]>[] points;

    public static void main(String[] args) {

        FastReader fr = new FastReader();

        N = fr.nextInt();
        K = fr.nextInt();

        points = new ArrayList[K + 1];

        for (int i = 1; i <= K; i++) {
            points[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            int x = fr.nextInt();
            int y = fr.nextInt();
            int color = fr.nextInt();

            points[color].add(new int[]{x, y});
        }

        dfs(0, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE);

        System.out.println(answer);
    }

    static void dfs(int cnt, int minX, int maxX, int minY, int maxY) {

        // 모든 색깔에서 하나씩 선택 완료
        if (cnt == K) {
            int area = (maxX - minX) * (maxY - minY);
            answer = Math.min(answer, area);
            return;
        }

        // 다음 색깔
        int color = cnt + 1;

        for (int[] point : points[color]) {
            int x = point[0];
            int y = point[1];

            int nextMinX = Math.min(minX, x);
            int nextMaxX = Math.max(maxX, x);
            int nextMinY = Math.min(minY, y);
            int nextMaxY = Math.max(maxY, y);

            int area = (nextMaxX - nextMinX) * (nextMaxY - nextMinY);

            // 앞으로 점을 더 추가해도 직사각형의 넓이는
            // 작아질 수 없으므로 탐색 중단
            if (area >= answer)
                continue;

            dfs(cnt + 1, nextMinX, nextMaxX, nextMinY, nextMaxY);
        }
    }

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                new InputStreamReader(System.in)
            );
        }

        String next() {

            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
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
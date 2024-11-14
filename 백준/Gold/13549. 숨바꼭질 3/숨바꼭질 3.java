import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        input();
        bfsWithTeleportation();
        System.out.println(checkWithTime[K]);
    }

    static FastReader scan = new FastReader();
    static int[] checkWithTime = new int[100001];
    static int N, K;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
    }

    static void bfsWithTeleportation() {
        Deque<Integer> deque = new LinkedList<>();
        Arrays.fill(checkWithTime, Integer.MAX_VALUE);  // 최대값으로 초기화
        deque.offerFirst(N);
        checkWithTime[N] = 0;  // 시작 위치의 시간을 0으로 설정

        while (!deque.isEmpty()) {
            int current = deque.pollFirst();

            // 목표 위치에 도달한 경우 탐색 종료
            if (current == K) break;

            // 순간이동 (비용 0)
            int teleportationIdx = current * 2;
            if (isValidIdx(teleportationIdx) && checkWithTime[teleportationIdx] > checkWithTime[current]) {
                deque.offerFirst(teleportationIdx);
                checkWithTime[teleportationIdx] = checkWithTime[current];
            }

            // 오른쪽 이동 (비용 1)
            int rightIdx = current + 1;
            if (isValidIdx(rightIdx) && checkWithTime[rightIdx] > checkWithTime[current] + 1) {
                deque.offerLast(rightIdx);
                checkWithTime[rightIdx] = checkWithTime[current] + 1;
            }

            // 왼쪽 이동 (비용 1)
            int leftIdx = current - 1;
            if (isValidIdx(leftIdx) && checkWithTime[leftIdx] > checkWithTime[current] + 1) {
                deque.offerLast(leftIdx);
                checkWithTime[leftIdx] = checkWithTime[current] + 1;
            }
        }
    }

    static boolean isValidIdx(int idx) {
        return idx >= 0 && idx < 100001;
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
    }
}



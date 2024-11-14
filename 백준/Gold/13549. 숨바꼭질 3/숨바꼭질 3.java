import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        input();
        bfsWithTeleportation();
        System.out.println(checkWithTime[K] - 1);
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static Queue<Integer> queue = new LinkedList<>();
    static int [] checkWithTime = new int [100001];
    static int N, K;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
    }

    static void bfsWithTeleportation() {
        queue.offer(N);
        Arrays.fill(checkWithTime, 0);
        checkWithTime[N] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

//            if(current == K)
//                break;

            int leftIdx = current - 1;
            if(isValidIdx(leftIdx) && (checkWithTime[leftIdx] == 0)) {
                queue.offer(leftIdx);
                checkWithTime[leftIdx] = checkWithTime[current] + 1;
            }
            else if (isValidIdx(leftIdx) && (checkWithTime[leftIdx] > checkWithTime[current]+1)) {
                queue.offer(leftIdx);
                checkWithTime[leftIdx] = checkWithTime[current] + 1;
            }

            int rightIdx = current + 1;
            if(isValidIdx(rightIdx) && (checkWithTime[rightIdx] == 0)) {
                queue.offer(rightIdx);
                checkWithTime[rightIdx] = checkWithTime[current] + 1;
            }
            else if (isValidIdx(rightIdx) && (checkWithTime[rightIdx] > checkWithTime[current]+1)) {
                queue.offer(rightIdx);
                checkWithTime[rightIdx] = checkWithTime[current] + 1;
            }

            int teleportationIdx = current * 2;
            if(isValidIdx(teleportationIdx) && (checkWithTime[teleportationIdx] == 0)) {
                queue.offer(teleportationIdx);
                checkWithTime[teleportationIdx] = checkWithTime[current];
            }
            else if (isValidIdx(teleportationIdx) && (checkWithTime[teleportationIdx] > checkWithTime[current])) {
                queue.offer(teleportationIdx);
                checkWithTime[teleportationIdx] = checkWithTime[current];
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
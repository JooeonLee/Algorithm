import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static FastReader scanner = new FastReader();
    static StringBuilder builder = new StringBuilder();

    static int N;
    static long diff = Long.MAX_VALUE;
    static int[] sourness_arr = new int[10];
    static int[] bitterness_arr = new int[10];

    public static void main(String[] args) {
        input();
        minDiff();
        System.out.println(diff);
    }

    static void input() {
        N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            sourness_arr[i] = scanner.nextInt();
            bitterness_arr[i] = scanner.nextInt();
        }
    }

    static void minDiff() {
        int lth = 1 << N;
        for(int i=1; i<lth; i++) {
            int current_s = 1;
            int current_b = 0;
            for(int j=0; j<N; j++) {
                if((i & 1<<j) > 0) { // i의 j 번째 비트가 1인 경우
                    current_s *= sourness_arr[j];
                    current_b += bitterness_arr[j];
                }
            }
            int current_diff = Math.abs(current_s - current_b);
            diff = Math.min(diff, current_diff);
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
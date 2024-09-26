import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static FastReader scanner = new FastReader();
    static StringBuilder builder = new StringBuilder();

    static int N;
    static long sourness_multi = 1;
    static long bitterness_sum = 0;
    static long diff = Long.MAX_VALUE;
    static int[] sourness_arr = new int[10];
    static int[] bitterness_arr = new int[10];

    public static void main(String[] args) {
        input();
        for(int r=1; r<N+1; r++)
            combination(new ArrayList<>(), new ArrayList<>(), 0, r);

        System.out.println(diff);
    }

    static void input() {
        N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            sourness_arr[i] = scanner.nextInt();
            bitterness_arr[i] = scanner.nextInt();
        }
    }


    static void combination(List<Integer> current_s, List<Integer> current_b, int start, int r) {
        if(current_s.size() == r) {
            long cur_s_mul = 1;
            long cur_b_sum = 0;
            long cur_diff = 0;

            for(int i = 0; i < current_s.size(); i++) {
                cur_s_mul *= current_s.get(i);
                cur_b_sum += current_b.get(i);
            }
            cur_diff = Math.abs(cur_s_mul - cur_b_sum);

            if(cur_diff < diff) {
                diff = cur_diff;
            }
        }

        for(int i = start; i < N; i++) {
            current_s.add(sourness_arr[i]);
            current_b.add(bitterness_arr[i]);

            combination(current_s, current_b, i + 1, r);
            current_s.remove(current_s.size() - 1);
            current_b.remove(current_b.size() - 1);
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
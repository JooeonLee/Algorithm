import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static FastReader scanner = new FastReader();
    static StringBuilder builder = new StringBuilder();

    static int N;
    static long diff = Long.MAX_VALUE;
    static int[] sourness_arr = new int[10];
    static int[] bitterness_arr = new int[10];
    static boolean[] isSelected = new boolean[10];

    public static void main(String[] args) {
        input();
        for(int r=1; r<N+1; r++) {
            init_isSelected();
            combination(0, 0, r);
        }

        System.out.println(diff);
    }

    static void input() {
        N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            sourness_arr[i] = scanner.nextInt();
            bitterness_arr[i] = scanner.nextInt();
        }
    }


    static void combination(int start, int selected, int r) {
        if(selected == r) {
            calculate();
            return;
        }

        for(int i = start; i < N; i++) {
            isSelected[i] = true;
            combination(i+1, selected+1, r);
            isSelected[i] = false;
        }
    }

    static void calculate() {
        long cur_s_mul = 1;
        long cur_b_sum = 0;
        int count = 0;

        for(int i = 0; i<N; i++) {
            if(isSelected[i]) {
                cur_s_mul *= sourness_arr[i];
                cur_b_sum += bitterness_arr[i];
                count++;
            }
        }

        if(count>0) {
            long cur_diff = Math.abs(cur_s_mul - cur_b_sum);
            if(cur_diff < diff) {
                diff = cur_diff;
            }
        }
    }

    static void init_isSelected() {
        for(int i=0; i<10; i++)
            isSelected[i] = false;
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
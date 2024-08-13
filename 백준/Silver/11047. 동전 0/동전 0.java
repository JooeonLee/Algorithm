import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
    static FastReader scanner = new FastReader();
    static StringBuilder builder = new StringBuilder();

    static int N, K, result = 0;
    static Vector<Integer> coins = new Vector<>();

    static void input() {
        N = scanner.nextInt();
        K = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            coins.add(scanner.nextInt());
        }
    }

    static void minimum_coin_num() {
        for(int i=coins.size()-1; i>=0; i--) {
            result += K / coins.get(i);
            K = K % coins.get(i);
        }
    }
    public static void main(String[] args) {
        input();
        minimum_coin_num();
        System.out.println(result);
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
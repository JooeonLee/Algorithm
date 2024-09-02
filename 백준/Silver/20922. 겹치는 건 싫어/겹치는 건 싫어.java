import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr = new int[200000];
    static int[] count = new int[100001];

    static FastReader scanner = new FastReader();
    static StringBuilder builder = new StringBuilder();

    static int N, K;

    static void input() {
        N = scanner.nextInt();
        K = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
    }

    static int maxLength() {
        int start = 0;
        int end = 0;
        int maxLength = 0;

        while (end < N) {
            if (count[arr[end]] != K) {
                count[arr[end]]++;
                end++;
            }
            else {
                count[arr[start]]--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        input();
        System.out.println(maxLength());
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
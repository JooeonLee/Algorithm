import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static FastReader scanner = new FastReader();
    static StringBuilder builder = new StringBuilder();

    static int N, M, Q;
    static int[][] arr;
    static int[][] sum;
    static int[][] query;

    static void input() {
        N = scanner.nextInt();
        M = scanner.nextInt();

        arr = new int[N+1][M+1];
        sum = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                arr[i][j] = scanner.nextInt();
                sum[i][j] = arr[i][j] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }

        Q = scanner.nextInt();
        query = new int[Q][4];
        for(int i = 0; i < Q; i++) {
            query[i][0] = scanner.nextInt();
            query[i][1] = scanner.nextInt();
            query[i][2] = scanner.nextInt();
            query[i][3] = scanner.nextInt();
        }
    }

    static void prefixSum() {
        int result;
        for(int i = 0; i < Q; i++) {
            result= sum[query[i][2]][query[i][3]] - sum[query[i][0]-1][query[i][3]] - sum[query[i][2]][query[i][1]-1] + sum[query[i][0]-1][query[i][1]-1];
            System.out.println(result);
        }
    }


    public static void main(String[] args) {
        input();
        prefixSum();
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
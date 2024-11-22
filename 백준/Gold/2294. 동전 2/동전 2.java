import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {

        input();
        solution();
        int result = dp[K];
        if(result == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else {
            System.out.println(result);
        }
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static int[] dp;
    static int[] coin;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        coin = new int[N];
        dp = new int[K+1];

        for (int i = 0; i < N; i++)
            coin[i] = scan.nextInt();

    }

    static void solution() {
        initDp();

        for(int i=0; i<N; i++) {
            for(int j=coin[i]; j<=K; j++) {
                if (dp[j - coin[i]] != Integer.MAX_VALUE) { // 유효한 경우만 갱신
                    dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
                }
            }
        }
    }

    static void initDp() {
        for(int i=0; i<K+1; i++)
            dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;
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
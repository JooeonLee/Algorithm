import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int m = fr.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = fr.nextInt();
            v[i] = fr.nextInt();
        }
        // Please write your code here.
        int[] dp = new int[m+1];
        // 냅색
        for(int i=0; i<n; i++) {
            int currW = w[i];
            int currV = v[i];

            for(int weight=m; weight>=currW; weight--) {
                dp[weight] = Math.max(dp[weight], dp[weight-currW] + currV);
            }
        }
        int answer = dp[m];
        // for(int i=0; i<=m; i++)
        //     answer = Math.max(answer, dp[i]);
        System.out.println(answer);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st==null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(Exception e) {
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
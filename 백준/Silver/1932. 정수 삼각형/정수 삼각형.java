import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++)
                arr[i][j] = fr.nextInt();
        }

        if(n==1) {
            System.out.println(arr[0][0]);
            return;
        }

        if(n==2) {
            System.out.println(Math.max(arr[0][0]+arr[1][0], arr[0][0]+arr[0][1]));
            return;
        }

        dp[0][0] = arr[0][0];
        dp[1][0] = dp[0][0] + arr[1][0];
        dp[1][1] = dp[0][0] + arr[1][1];

        for(int i=2; i<n; i++) {
            for(int j=0; j<=i; j++) {
                if(j==0)
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                else if(j==i)
                    dp[i][j] = dp[i-1][j-1] + arr[i][j];
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + arr[i][j];
                }
            }
        }

        int answer = -1;

        for(int i=0; i<n; i++) {
            if(dp[n-1][i] > answer)
                answer = dp[n-1][i];
        }

        System.out.println(answer);

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

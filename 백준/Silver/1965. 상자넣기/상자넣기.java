// 출처: 백준 NUMBER_PLACEHOLDER
// 링크: LINK_PLACEHOLDER
// 난이도: DIFFICULTY_PLACEHOLDER
// 풀이일: DATE_PLACEHOLDER

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = fr.nextInt();

        dp[0] = 1;
        for(int i=1; i<n; i++) {
            int localMax = 0;
            for(int j=0; j<i; j++) {
                if(arr[j] < arr[i]) {
                    if(localMax < dp[j])
                        localMax = dp[j];
                }
            }
            dp[i] = localMax + 1;
        }

        int answer = 0;
        for(int i=0; i<n; i++)
            if(answer < dp[i])
                answer = dp[i];
        
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

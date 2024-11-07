import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        input();
        System.out.println(solution());
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static long[] prefixSum;
    static Map<Long, Long> prefixSumMap = new HashMap<>();


    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        prefixSum = new long[N+1];

        for (int i = 1; i < N+1; i++) {
            prefixSum[i] = prefixSum[i - 1] + scan.nextLong();
        }
    }

    static long solution() {
        long count = 0;
        prefixSumMap.put(0L, 1L);

        for(int i=1; i<N+1; i++) {

            count += prefixSumMap.getOrDefault(prefixSum[i] - K, 0L);

            prefixSumMap.put(prefixSum[i], prefixSumMap.getOrDefault(prefixSum[i], 0L) + 1);
        }
        return count;
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
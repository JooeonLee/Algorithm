import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        input();
        System.out.println(solution());
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static long[] times;
    static long max = 0;
    static long min = Long.MAX_VALUE;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        times = new long[N];
        for (int i = 0; i < N; i++) {
            times[i] = scan.nextInt();
            max = Math.max(max, times[i]);
            min = Math.min(min, times[i]);
        }
    }

    static long solution() {
        long left = min;
        long right = max*M;
        long answer = right;

        while (left <= right) {
            long mid = (right + left) / 2;
            long people = 0;

            for(long time: times) {
                people += mid / time;
                if(people >= M)
                    break;
            }

            if(people >= M) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
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
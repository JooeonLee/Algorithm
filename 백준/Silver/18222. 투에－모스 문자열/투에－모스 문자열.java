import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        input();
        solution();
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static long N;

    static void input() {
        N = scan.nextLong();
    }

    static void solution() {
        System.out.println(divideAndConquer(N));
    }

    static int divideAndConquer(long n) {

        if(n == 1) {
            return 0;
        }

        long length = largestPower2Below(n);
        
        return 1 - divideAndConquer(n - length);

    }

    static long largestPower2Below(long n) {
        long i = 1;
        while(i * 2 < n) {
            i *= 2;
        }
        return i;
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
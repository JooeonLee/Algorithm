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

    static int N, M;
    static int[] numbers;
    static boolean[] check;
    static int[] result;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        numbers = new int[N];
        check = new boolean[N];
        result = new int[M];
        for (int i = 0; i < N; i++) {
            numbers[i] = scan.nextInt();
        }
    }

    static void solution() {

        Arrays.sort(numbers);
        permutation(M);
        System.out.print(sb.toString());
    }

    static void permutation(int r) {
        if(r==0) {
            for(int i=0; i<M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append('\n');
        }
        else {
            for(int i=0; i<N; i++) {
                if(!check[i]) {
                    check[i] = true;
                    result[M - r] = numbers[i];
                    permutation(r - 1);
                    check[i] = false;
                }
            }
        }
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
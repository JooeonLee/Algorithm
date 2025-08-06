import java.util.*;
import java.io.*;


public class Main {
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
    }

    static int N, M;
    static int before = 0;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M+1];

    }

    static void rec_func(int k) {
        if(k == M+1) {
            for(int i=1; i<=M; i++)
                sb.append(selected[i]).append(" ");
            sb.append("\n");
            return;
        } else {
            for(int cand=1; cand<=N; cand++) {
                if(cand < before)
                    continue;
                selected[k] = cand;
                before = cand;
                rec_func(k+1);
                selected[k] = 0;
                before = 0;
            }
        }
    }
    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.print(sb);
    }
}

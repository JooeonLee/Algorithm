import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) {
        FastReader fr = new FastReader();

        N = fr.nextInt();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++)
                S[i][j] = fr.nextInt();
        }

        combi(0, 0);

        System.out.println(min);
    }

    static int min = Integer.MAX_VALUE;
    static int[] check = new int[20];
    static int[] selected = new int[10];
    static int N;
    static int[][] S = new int[20][20];
    static void combi(int idx, int sidx) {
        if(idx >= N)
            return;
        if(sidx >= N/2) {
            int result = cal();
            if(min > result)
                min = result;
            return;
        }
        check[idx] = 1;
        selected[sidx] = idx;
        combi(idx+1, sidx+1);
        check[idx] = 0;
        combi(idx+1, sidx);
    }

    static int cal() {
        int num1 = 0;
        int num2 = 0;

        for(int i=0; i<N/2; i++) {
            for(int j=0; j<N/2; j++) {
                num1 += S[selected[i]][selected[j]];
            }
        }

        int[] unSelected = new int[N/2];
        int uIdx = 0;
        for(int i=0; i<N; i++) {
            if(check[i] == 0) {
                unSelected[uIdx] = i;
                uIdx++;
            }
        }
        for(int i=0; i<N/2; i++) {
            for(int j=0; j<N/2; j++) {
                num2 += S[unSelected[i]][unSelected[j]];
            }
        }

        return Math.abs(num1 - num2);
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

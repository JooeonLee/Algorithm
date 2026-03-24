import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int N = fr.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = fr.nextInt();
        }

        if (N == 1) {
            System.out.println(arr[0]);
        } else if (N == 2) {
            System.out.println(arr[0] + arr[1]);
        } else if (N == 3) {
            System.out.println(Math.max(arr[0], arr[1]) + arr[2]);
        } else {
            int[] maxValue = new int[N];

            maxValue[0] = arr[0];
            maxValue[1] = arr[0] + arr[1];
            maxValue[2] = Math.max(arr[0], arr[1]) + arr[2];

            for (int i = 3; i < N; i++) {
                maxValue[i] = Math.max(maxValue[i - 3] + arr[i - 1], maxValue[i - 2]) + arr[i];
            }

            System.out.println(maxValue[N - 1]);
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
    }
}
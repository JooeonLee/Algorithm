import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) {
        input();
        solution();
    }

    static FastReader scan = new FastReader();

    static void input() {
        N = scan.nextInt();
        arr = new int[N];

        for(int i=0; i<N; i++)
            arr[i] = scan.nextInt();
    }


    static void solution() {

        int left = 0;
        int right = N - 1;
        int maxScore = Integer.MIN_VALUE;

        while(left < right) {
            int distance = right - left - 1;
            int score = distance * Math.min(arr[left], arr[right]);

            maxScore = Math.max(maxScore, score);

            if(arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(maxScore);
    }

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

        long nextLong() {
            return Long.parseLong(next());
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
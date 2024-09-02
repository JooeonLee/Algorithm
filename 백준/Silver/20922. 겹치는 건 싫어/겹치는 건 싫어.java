import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {

    static FastReader scanner = new FastReader();
    static StringBuilder builder = new StringBuilder();

    static int N, K;
    static Vector<Integer> arr = new Vector<>();
    static HashMap<Integer, Integer> countMap = new HashMap<>();

    static void input() {
        N = scanner.nextInt();
        K = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            arr.add(scanner.nextInt());
        }
    }

    static int maxLength() {
        int start = 0;
        int maxLength = 0;

        for(int end=0; end<N; end++) {
            countMap.put(arr.get(end), countMap.getOrDefault(arr.get(end), 0) + 1);

            while(countMap.get(arr.get(end)) > K) {
                countMap.put(arr.get(start), countMap.get(arr.get(start)) - 1);
                if(countMap.get(arr.get(start)) == 0) {
                    countMap.remove(arr.get(start));
                }
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        input();
        System.out.println(maxLength());
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
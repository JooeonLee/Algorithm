import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {

    static FastReader scanner = new FastReader();
    static StringBuilder builder = new StringBuilder();

    static int N, K;
    static int[] arr = new int[50000];

    public static void main(String[] args) {
        input();
        System.out.println(maxEvenLength());
    }

    static void input() {
        N = scanner.nextInt();
        K = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
    }

    static int maxEvenLength() {
        int maxEvenLength = 0;  // 짝수로만 이루어진 가장 긴 부분 수열의 길이
        int oddCount = 0;       // 현재 윈도우 내의 홀수 개수
        int start = 0;          // 슬라이딩 윈도우의 시작점

        // 슬라이딩 윈도우 알고리즘
        for (int end = 0; end < N; end++) {
            // 홀수를 만난 경우
            if (arr[end] % 2 != 0) {
                oddCount++;
            }

            // 홀수의 개수가 K를 초과한 경우, 윈도우의 시작점을 이동
            while (oddCount > K) {
                if (arr[start] % 2 != 0) {
                    oddCount--;
                }
                start++;
            }

            // 현재 윈도우 내의 짝수의 개수 계산
            int evenLength = end - start + 1 - oddCount;
            maxEvenLength = Math.max(maxEvenLength, evenLength);
        }

        // 결과 반환
        return maxEvenLength;
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
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        input();
        System.out.println(solution(N/2, 0, 0));
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] matrix = new int[1024][1024];


    static void input() {
        N = scan.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
    }

    static int solution(int divideSize, int leftTopX, int leftTopY) {
        int[] divideMatrix = new int[4];

        // 탈출조건
        if(divideSize == 1) {
            divideMatrix[0] = matrix[leftTopX][leftTopY];
            divideMatrix[1] = matrix[leftTopX+1][leftTopY];
            divideMatrix[2] = matrix[leftTopX][leftTopY+1];
            divideMatrix[3] = matrix[leftTopX+1][leftTopY+1];
        }

        else {
            divideMatrix[0] = solution(divideSize/2, leftTopX, leftTopY);
            divideMatrix[1] = solution(divideSize/2, leftTopX+divideSize, leftTopY);
            divideMatrix[2] = solution(divideSize/2, leftTopX, leftTopY+divideSize);
            divideMatrix[3] = solution(divideSize/2, leftTopX+divideSize, leftTopY+divideSize);

        }
        Arrays.sort(divideMatrix);
        return divideMatrix[2];
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
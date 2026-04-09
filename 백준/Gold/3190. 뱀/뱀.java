import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int[][] board = new int[N][N];
        int[][] check = new int[N][N];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        Queue<int[]> snake = new LinkedList<>();

        int K = fr.nextInt();
        for(int i = 0; i < K; i++) {
            int r = fr.nextInt() - 1;
            int c = fr.nextInt() - 1;
            board[r][c] = 1;
        }

        int L = fr.nextInt();
        HashMap<Integer, Character> dMap = new HashMap<>();
        for(int i = 0; i < L; i++) {
            int time = fr.nextInt();
            char d = fr.next().charAt(0);
            dMap.put(time, d);
        }

        int time = 1;
        int currR = 0, currC = 0;
        int currDIdx = 0;
        snake.offer(new int[]{currR, currC});
        check[0][0] = 1;

        while(true) {
            int nextR = currR + dr[currDIdx];
            int nextC = currC + dc[currDIdx];

            if(isValid(N, nextR, nextC, check)) {
                check[nextR][nextC] = 1;
                snake.offer(new int[]{nextR, nextC});
            } else {
                break;
            }

            if(board[nextR][nextC] == 1) {
                board[nextR][nextC] = 0;
            } else {
                int[] tail = snake.poll();
                check[tail[0]][tail[1]] = 0;
            }

            char turn = dMap.getOrDefault(time, 'N');
            if(turn == 'L') {
                currDIdx = turnLeft(currDIdx);
            } else if(turn == 'D') {
                currDIdx = turnRight(currDIdx);
            }

            currR = nextR;
            currC = nextC;
            time++;
        }

        System.out.println(time);
    }

    static boolean isValid(int N, int r, int c, int[][] check) {
        return r >= 0 && r < N && c >= 0 && c < N && check[r][c] != 1;
    }

    static int turnLeft(int idx) {
        return (idx + 3) % 4;
    }

    static int turnRight(int idx) {
        return (idx + 1) % 4;
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
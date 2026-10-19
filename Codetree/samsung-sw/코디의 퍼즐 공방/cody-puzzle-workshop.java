import java.util.*;
import java.io.*;

/**
N^2 이 최대 4 * 10^6 이고 명령 수가 10^5이므로 스페어 때마다 보드 순회 불가능
*/
public class Main {
    // 0 up, 1 right, 2 down, 3 left
    static int[] div = {1000, 100, 10, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int board[][];
    static int N;

    static int[] spareCnt;
    static int[] holeCnt;
    static long score;

    public static void main(String[] args) {
        // Please write your code here.
        FastReader fr = new FastReader();
        StringBuilder sb = new StringBuilder();

        int Q = fr.nextInt();

        for(int i=0; i<Q; i++) {
            int cmd = fr.nextInt();

            if(cmd == 100) {
                N = fr.nextInt();
                init();
            }
            else if(cmd == 200) {
                int y = fr.nextInt();
                int x = fr.nextInt();
                int up = fr.nextInt();
                int right = fr.nextInt();
                int down = fr.nextInt();
                int left = fr.nextInt();

                putPuzzle(y, x, up, right, down, left);
            }
            else if(cmd == 300) {
                int y = fr.nextInt();
                int x = fr.nextInt();

                removePuzzle(y, x);
            }
            else if(cmd == 400) {
                int up = fr.nextInt();
                int right = fr.nextInt();
                int down = fr.nextInt();
                int left = fr.nextInt();

                addSpare(up, right, down, left);
            }
            else if(cmd == 500) {
                sb.append(score).append('\n');
            }
        }
        System.out.print(sb);
    }

    static int encode(int up, int right, int down, int left) {
        return up*1000+right*100+down*10+left;
    }

    static int getShape(int shape, int dir) {
        return shape/div[dir] % 10;
    }

    static int rotate(int shape) {
        return (shape%10) * 1000 + shape/10;
    }

    static int getRepresentShape(int shape) {
        int result = shape;

        for(int i=0; i<3; i++) {
            shape = rotate(shape);
            result = Math.min(result, shape);
        }

        return result;
    }

    static boolean inRange(int y, int x) {
        return y>=1 && y<=N && x>=1 && x<=N;
    }

    static int getHoleShape(int y, int x) {
        if(board[y][x] != -1)
            return -1;
        
        int shape = 0;

        for(int dir = 0; dir<4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            int side;

            if(!inRange(ny, nx))
                side = 1;
            else {
                if(board[ny][nx] == -1)
                    return -1;
                
                int opposite = (dir+2) % 4;
                int nSide = getShape(board[ny][nx], opposite);

                side = 2 - nSide;
            }

            shape = shape * 10 + side;
        }

        return getRepresentShape(shape);
    }

    static void updateHole(int y, int x, int d) {
        if (!inRange(y, x)) {
            return;
        }

        int shape = getHoleShape(y, x);

        if (shape == -1) {
            return;
        }

        holeCnt[shape] += d;
        score += d * spareCnt[shape];
    }

    static void updateAround(int y, int x, int d) {
        updateHole(y, x, d);

        for (int dir = 0; dir < 4; dir++) {
            updateHole(y + dy[dir], x + dx[dir], d);
        }
    }

    static void init() {
        board = new int[N+1][N+1];
        for(int i=1; i<=N; i++)
            for(int j=1; j<=N; j++)
                board[i][j] = -1;

        spareCnt = new int[2223];
        holeCnt = new int[2223];
        score = 0;
    }

    static void putPuzzle(int y, int x, int up, int right, int down, int left) {
        updateAround(y, x, -1);
        int shape = encode(up, right, down, left);
        board[y][x] = shape;
        updateAround(y, x, 1);
    }

    static void removePuzzle(int y, int x) {
        updateAround(y, x, -1);
        board[y][x] = -1;
        updateAround(y, x, 1);
    }

    static void addSpare(int up, int right, int down, int left) {
        int shape = getRepresentShape(encode(up, right, down, left));
        score += holeCnt[shape];
        spareCnt[shape]++;  
    }



    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st==null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(Exception e) {
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
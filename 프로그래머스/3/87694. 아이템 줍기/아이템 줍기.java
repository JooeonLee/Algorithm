import java.util.*;

class Solution {
    static final int MAX = 102;
    static int[][] board = new int[MAX][MAX];
    static int[][] dist = new int[MAX][MAX];
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int i = 0; i < MAX; i++) {
            Arrays.fill(board[i], 0);
            Arrays.fill(dist[i], -1);
        }

        for (int[] r : rectangle) {
            int x1 = r[0] * 2, y1 = r[1] * 2;
            int x2 = r[2] * 2, y2 = r[3] * 2;
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    board[x][y] = 1;
                }
            }
        }

        for (int[] r : rectangle) {
            int x1 = r[0] * 2, y1 = r[1] * 2;
            int x2 = r[2] * 2, y2 = r[3] * 2;
            for (int x = x1 + 1; x <= x2 - 1; x++) {
                for (int y = y1 + 1; y <= y2 - 1; y++) {
                    board[x][y] = 0;
                }
            }
        }

        int sx = characterX * 2, sy = characterY * 2;
        int tx = itemX * 2, ty = itemY * 2;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy});
        dist[sx][sy] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if (x == tx && y == ty) break;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= MAX || ny >= MAX) continue;
                if (board[nx][ny] != 1) continue;
                if (dist[nx][ny] != -1) continue;

                dist[nx][ny] = dist[x][y] + 1;
                q.add(new int[]{nx, ny});
            }
        }

        return dist[tx][ty] / 2;
    }
}
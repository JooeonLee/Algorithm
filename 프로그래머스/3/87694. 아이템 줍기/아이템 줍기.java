import java.util.*;

class Solution {
    static final int MAX = 102; // 좌표 최대 50 * 2 = 100, 여유 포함
    static int[][] board = new int[MAX][MAX];
    static int[][] dist = new int[MAX][MAX];
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 1) 보드 초기화
        for (int i = 0; i < MAX; i++) {
            Arrays.fill(board[i], 0);
            Arrays.fill(dist[i], -1);
        }

        // 2) 모든 직사각형 영역을 채운다(테두리+내부)
        for (int[] r : rectangle) {
            int x1 = r[0] * 2, y1 = r[1] * 2;
            int x2 = r[2] * 2, y2 = r[3] * 2;
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    board[x][y] = 1;
                }
            }
        }

        // 3) 각 직사각형의 내부를 지워서 테두리만 남긴다
        for (int[] r : rectangle) {
            int x1 = r[0] * 2, y1 = r[1] * 2;
            int x2 = r[2] * 2, y2 = r[3] * 2;
            for (int x = x1 + 1; x <= x2 - 1; x++) {
                for (int y = y1 + 1; y <= y2 - 1; y++) {
                    board[x][y] = 0;
                }
            }
        }

        // 4) BFS는 테두리(board==1)만 이동
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
                if (board[nx][ny] != 1) continue;      // 테두리만
                if (dist[nx][ny] != -1) continue;

                dist[nx][ny] = dist[x][y] + 1;
                q.add(new int[]{nx, ny});
            }
        }

        // 2배 좌표에서의 이동거리이므로 /2
        return dist[tx][ty] / 2;
    }
}
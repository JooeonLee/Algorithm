import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        ArrayDeque<int[]> queue = new ArrayDeque<>();

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(picture[r][c] == 0 || visited[r][c]) {
                    continue;
                }

                // 방문하지 않은 색칠된 칸 → 새로운 영역
                numberOfArea++;

                int color = picture[r][c];
                int area = 1;

                visited[r][c] = true;
                queue.offerLast(new int[]{r, c});

                while(!queue.isEmpty()) {
                    int[] cur = queue.pollFirst();

                    for(int d = 0; d < 4; d++) {
                        int nr = cur[0] + dr[d];
                        int nc = cur[1] + dc[d];

                        if(nr < 0 || nr >= m || nc < 0 || nc >= n)
                            continue;

                        if(visited[nr][nc] || picture[nr][nc] != color)
                            continue;

                        visited[nr][nc] = true;
                        queue.offerLast(new int[]{nr, nc});
                        area++;
                    }
                }

                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
            }
        }

        return new int[]{numberOfArea, maxSizeOfOneArea};
    }
}
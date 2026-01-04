import java.util.*;

class Solution {
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    public int solution(int[][] game_board, int[][] table) {
        int n = game_board.length;

        // 1) 빈칸(0) 덩어리 추출 + canonical 키 리스트
        List<Shape> holes = extractShapes(game_board, 0);

        // 2) 블록(1) 덩어리 추출 + canonical 키 카운팅
        List<Shape> blocks = extractShapes(table, 1);
        Map<String, Integer> blockCount = new HashMap<>();
        for (Shape b : blocks) {
            blockCount.put(b.key, blockCount.getOrDefault(b.key, 0) + 1);
        }

        // 3) 빈칸을 순회하며 매칭
        int answer = 0;
        for (Shape h : holes) {
            int cnt = blockCount.getOrDefault(h.key, 0);
            if (cnt > 0) {
                blockCount.put(h.key, cnt - 1);
                answer += h.size;
            }
        }

        return answer;
    }

    // 연결 컴포넌트(값이 target인 덩어리)들을 모두 뽑아서 Shape 리스트로 반환
    private List<Shape> extractShapes(int[][] grid, int target) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        List<Shape> shapes = new ArrayList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (!visited[r][c] && grid[r][c] == target) {
                    List<int[]> cells = bfs(grid, visited, r, c, target);
                    String key = canonicalKey(cells);
                    shapes.add(new Shape(cells.size(), key));
                }
            }
        }
        return shapes;
    }

    private List<int[]> bfs(int[][] grid, boolean[][] visited, int sr, int sc, int target) {
        int n = grid.length;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        List<int[]> cells = new ArrayList<>();

        visited[sr][sc] = true;
        q.offer(new int[]{sr, sc});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            cells.add(new int[]{r, c});

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (visited[nr][nc]) continue;
                if (grid[nr][nc] != target) continue;
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }
        return cells;
    }

    // 회전(4방향) 중 정규화 인코딩 문자열이 가장 작은 것을 canonical 키로 사용
    private String canonicalKey(List<int[]> cells) {
        int m = cells.size();
        int[][] arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            arr[i][0] = cells.get(i)[0];
            arr[i][1] = cells.get(i)[1];
        }

        String best = null;
        int[][] cur = arr;

        for (int rot = 0; rot < 4; rot++) {
            String enc = normalizeAndEncode(cur);
            if (best == null || enc.compareTo(best) < 0) best = enc;
            cur = rotate90(cur); // 다음 회전
        }
        return best;
    }

    // (r,c)들을 min r, min c가 0이 되게 이동 후 정렬하여 문자열로 인코딩
    private String normalizeAndEncode(int[][] pts) {
        int minR = Integer.MAX_VALUE, minC = Integer.MAX_VALUE;
        for (int[] p : pts) {
            minR = Math.min(minR, p[0]);
            minC = Math.min(minC, p[1]);
        }

        int m = pts.length;
        int[][] norm = new int[m][2];
        for (int i = 0; i < m; i++) {
            norm[i][0] = pts[i][0] - minR;
            norm[i][1] = pts[i][1] - minC;
        }

        Arrays.sort(norm, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        StringBuilder sb = new StringBuilder();
        for (int[] p : norm) {
            sb.append(p[0]).append(',').append(p[1]).append(';');
        }
        return sb.toString();
    }

    // 90도 회전: (r,c) -> (c, -r)
    private int[][] rotate90(int[][] pts) {
        int m = pts.length;
        int[][] out = new int[m][2];
        for (int i = 0; i < m; i++) {
            int r = pts[i][0];
            int c = pts[i][1];
            out[i][0] = c;
            out[i][1] = -r;
        }
        return out;
    }

    private static class Shape {
        int size;
        String key;
        Shape(int size, String key) {
            this.size = size;
            this.key = key;
        }
    }
}
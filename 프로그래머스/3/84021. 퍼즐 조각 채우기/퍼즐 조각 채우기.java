import java.util.*;

class Solution {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    
    public int solution(int[][] game_board, int[][] table) {
        List<Shape> holes = extractShapes(game_board, 0);
        List<Shape> blocks = extractShapes(table, 1);
        
        Map<String, Integer> blockCount = new HashMap<>();
        
        for(Shape b : blocks) {
            blockCount.put(b.key, blockCount.getOrDefault(b.key, 0) + 1);
        }
        
        int answer = 0;
        
        for(Shape h : holes) {
            int cnt = blockCount.getOrDefault(h.key, 0);
            
            if(cnt > 0) {
                blockCount.put(h.key, cnt -1);
                answer += h.size;
            }
        }
        
        return answer;
    }
    
    private String canonicalKey(List<int[]> cells) {
        int length = cells.size();
        int[][] arr = new int[length][2];
        
        for(int i=0; i<length; i++) {
            arr[i][0] = cells.get(i)[0];
            arr[i][1] = cells.get(i)[1];
        }
        
        String best = null;
        int[][] curr = arr;
        
        for(int i=0; i<4; i++) {
            String encode = normalizeAndEncode(curr);
            
            if(best==null || encode.compareTo(best) < 0) {
                best = encode;
            }
            
            curr = rotate90(curr);
        }
        
        return best;
    }
    
    private int[][] rotate90(int[][] pts) {
        int length = pts.length;
        int[][] out = new int[length][2];
        
        for(int i=0; i<length; i++) {
            int r = pts[i][0];
            int c = pts[i][1];
            
            out[i][0] = c;
            out[i][1] = -r;
        }
        
        return out;
    }
    
    private String normalizeAndEncode(int[][] pts) {
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        
        for(int[] p : pts) {
            minR = Math.min(minR, p[0]);
            minC = Math.min(minC, p[1]);
        }
        
        int length = pts.length;
        int[][] norm = new int[length][2];
        
        for(int i=0; i<length; i++) {
            norm[i][0] = pts[i][0] - minR;
            norm[i][1] = pts[i][1] - minC;
        }
        
        Arrays.sort(norm, (a, b) -> {
            if(a[0] != b[0])
                return a[0] - b[0];
            else
                return a[1] - b[1];
        });
        
        StringBuilder sb = new StringBuilder();
        
        for(int[] p : norm) {
            sb.append(p[0]).append(',').append(p[1]).append(';');
        }
        
        return sb.toString();
    }
    
    private List<Shape> extractShapes(int[][] grid, int target) {
        int length = grid[0].length;
        boolean[][] visited = new boolean[length][length];
        List<Shape> shapes = new ArrayList<>();
        
        for(int i=0; i<length; i++) {
            for(int j=0; j<length; j++) {
                if(grid[i][j] == target && visited[i][j] == false) {
                    List<int[]> cells = bfs(grid, visited, target, i, j);
                    
                    String key = canonicalKey(cells);
                    
                    shapes.add(new Shape(cells.size(), key));
                }
            }
        }
        
        return shapes;
    }
    
    private List<int[]> bfs(int[][] grid, boolean[][] visited, int target, int sr, int sc) {
        int length = grid[0].length;
        List<int[]> cells = new ArrayList<>();
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        int[] start = new int[] {sr, sc};
        queue.offer(start);
        cells.add(start);
        visited[sr][sc] = true;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currR = curr[0];
            int currC = curr[1];
            
            for(int i=0; i<4; i++) {
                int nextR = currR + dr[i];
                int nextC = currC + dc[i];
                
                if(nextR < 0 || nextR >= length || nextC < 0 || nextC >= length)
                    continue;
                if(visited[nextR][nextC])
                    continue;
                if(grid[nextR][nextC] != target)
                    continue;
                
                int[] next = new int[] {nextR, nextC};
                queue.offer(next);
                cells.add(next);
                visited[nextR][nextC] = true;
            }
        }
        
        return cells;
    }
    
    static class Shape {
        int size;
        String key;
        
        Shape(int size, String key) {
            this.size = size;
            this.key = key;
        }
    }
}
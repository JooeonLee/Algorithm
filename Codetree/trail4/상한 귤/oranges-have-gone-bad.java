import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] grid = new int[n][n];
        int[][] result = new int[n][n];
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 0)
                    result[i][j] = -1;
                else if(grid[i][j] == 1)
                    result[i][j] = -2;
                else
                    q.offer(new int[]{i, j, 0});
            }
        }
        // Please write your code here.
        while(!q.isEmpty()) {
            int[] curr = q.poll();

            for(int i=0; i<4; i++) {
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];

                if(nr<0 || nr>=n || nc<0 || nc>=n)
                    continue;
                if(grid[nr][nc]==0)
                    continue;
                
                if(result[nr][nc]==-2) {
                    q.offer(new int[]{nr, nc, curr[2]+1});
                    result[nr][nc] = curr[2]+1;
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++)
                System.out.print(result[i][j] + " ");
            System.out.println();
        }
    }
}
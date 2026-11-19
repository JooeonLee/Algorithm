import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] grid;
    static int[][][] visited;
    static int[] dr = new int[]{1, 0, -1, 0};
    static int[] dc = new int[]{0, -1, 0, 1};

    public static void main(String[] args) {
        // Please write your code here.
        FastReader fr = new FastReader();
        n = fr.nextInt();
        grid = new int[n][n];
        visited = new int[n][n][4];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                grid[i][j] = fr.nextInt();

        ArrayDeque<int[]> q = new ArrayDeque<>();
        int answer=-1;
        // r, c, time, dir
        q.offerLast(new int[]{1, 1, 0, -1});
        while(!q.isEmpty()) {
            int[] curr = q.pollFirst();

            if(curr[0]==n-2 && curr[1]==n-2) {
                answer = curr[2];
                break;
            }

            if(curr[3]==-1) {
                for(int i=0; i<4; i++) {
                    int nr = curr[0] + dr[i];
                    int nc = curr[1] + dc[i];

                    if(!isValidIdx(nr, nc))
                        continue;
                    if(grid[nr][nc]==1)
                        continue;
                    if(visited[nr][nc][i]==1)
                        continue;
                    q.offerLast(new int[]{nr, nc, curr[2]+1, i});
                    visited[nr][nc][i] = 1;
                }
            }
            else {
                int nr = curr[0] + dr[curr[3]];
                int nc = curr[1] + dc[curr[3]];

                if(!isValidIdx(nr, nc) || grid[nr][nc]==1) {
                    for(int i=0; i<4; i++) {
                        nr = curr[0] + dr[i];
                        nc = curr[1] + dc[i];

                        if(!isValidIdx(nr, nc))
                            continue;
                        if(grid[nr][nc]==1)
                            continue;
                        if(visited[nr][nc][i]==1)
                            continue;
                        
                        q.offerLast(new int[]{nr, nc, curr[2]+1, i});
                        visited[nr][nc][i] = 1;
                    }
                }
                else if(visited[nr][nc][curr[3]] == 0) {
                    q.offerLast(new int[]{nr, nc, curr[2]+1, curr[3]});
                    visited[nr][nc][curr[3]] = 1;
                }
            }
        }
        System.out.println(answer);

    }

    static boolean isValidIdx(int r, int c) {
        return r>=0 && r<n && c>=0 && c<n;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while(st==null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
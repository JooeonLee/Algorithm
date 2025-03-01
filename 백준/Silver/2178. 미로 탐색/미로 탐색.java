import java.util.*;
import java.io.*;

public class Main {

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
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		String nextLine() {
			String str = "";
			
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	static void input() {
		FastReader scan = new FastReader();
		
		N = scan.nextInt();
		M = scan.nextInt();
		graph = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String str = scan.nextLine();
			for(int j=0; j<M; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}
	}
	
	static boolean isValidIdx(int x, int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}
	
	static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[]{0, 0, 1});
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			if(curr[0] == N-1 && curr[1] == M-1)
				return curr[2];
			
			for(int i=0; i<4; i++) {
				int nx = curr[0] + dx[i];
				int ny = curr[1] + dy[i];
				
				if(isValidIdx(nx, ny) && graph[nx][ny]==1 && !visited[nx][ny]) {
					queue.add(new int[]{nx, ny, curr[2]+1});
                    visited[nx][ny] = true;
                }
			}
		}
        return -1;
	}
	
	public static void main(String args[]) {
		input();
		System.out.println(bfs());
	}
}
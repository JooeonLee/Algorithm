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
		
			while(st == null || !st.hasMoreTokens()) {
				try{
					st = new StringTokenizer(br.readLine());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			
			return st.nextToken();
		}
		
		long nextLong() {
		
			return Long.parseLong(next());
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	
	static long N, M;
	static long[] trees;
	
	static void input() {
	
		FastReader scan = new FastReader();
		N = scan.nextLong();
		M = scan.nextLong();
		trees = new long[(int)N+1];
		
		for(int i=1; i<N+1; i++) {
			trees[i] = scan.nextLong();
		}
	}
	
	static boolean determination(long H) {
		
		long sum = 0;
		
		for(int i=1; i<N+1; i++) {
			if(trees[i] > H) {
				sum += (long) trees[i] - H;
			}
		}
		
		return sum >= M;
	}
	
	static void solution() {
	
		long left = 0, right = 2000000000, answer = 0;
		
		while(left <= right) {
		
			long mid = (left+right) / 2;
			if(determination(mid)) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(answer);
	}
	
	public static void main(String args[]) {
	
		input();
		solution();
	}
}
import java.io.*;
import java.util.*;

public class Main {

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
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
		
		long nextLong() {
			return Long.parseLong(next());
		}
	}
	
	// 전역 변수들
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] selected;
	
	// 입력함수
	static void input() {
		FastReader scan = new FastReader();
		N = scan.nextInt();
		M = scan.nextInt();
		selected = new int[M+1];
	}
	
	// PS 함수
	// 재귀 함수
	static void rec_func(int k) {
		if(k == M+1) {
			for(int i=1; i<=M; i++)
				sb.append(selected[i]).append(' ');
				sb.append('\n');
		} else {
			for(int cand=1; cand<=N; cand++) {
				selected[k] = cand;
				rec_func(k+1);
				selected[k] = 0;
			}
		}
	}
	
	// main 함수
	public static void main(String[] args) {
		input();
		rec_func(1);
		System.out.println(sb.toString());
	}
}
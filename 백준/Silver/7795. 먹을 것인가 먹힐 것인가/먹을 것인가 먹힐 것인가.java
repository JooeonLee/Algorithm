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
	}
	
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] A;
	static int[] B;
	
	static int lower_bound(int[] A, int left, int right, int target) {
		int result = left - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(A[mid] < target) {
				result = mid;
				left = mid + 1;
			}
			else if(A[mid] >= target) {
				right = mid - 1;
			}
		}
		
		return result;
	}
	
	static void solution() {
		Arrays.sort(B, 1, M+1);
		
		int ans = 0;
		for(int i=1; i<=N; i++) {
			ans += lower_bound(B, 1, M, A[i]);
		}
		sb.append(ans).append('\n'); 
	}
	
	public static void main(String args[]) {
		FastReader scan = new FastReader();
		int testCase = scan.nextInt();
		
		for(int i=0; i<testCase; i++) {
			N = scan.nextInt();
			M = scan.nextInt();
			A = new int[N+1];
			B = new int[M+1];
			
			for(int j=1; j<N+1; j++)
				A[j] = scan.nextInt();
				
			for(int j=1; j<M+1; j++)
				B[j] = scan.nextInt();
				
			solution();
		}
		
		System.out.println(sb.toString());
	}
}
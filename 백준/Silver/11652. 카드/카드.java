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
		
		long nextLong() {
			return Long.parseLong(next());
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static long[] arr;
	
	static void input() {
		FastReader scan = new FastReader();
		N = scan.nextInt();
		arr = new long[N];
		for(int i=0; i<N; i++)
			arr[i] = scan.nextLong();
	}
	
	static void solution() {
		Arrays.sort(arr);
		
		long answer = arr[0];
		long pre = arr[0];
		int count = 1;
		int max = 1;
		for(int i=1; i<N; i++) {
			long curr = arr[i];
			if(curr == pre) {
				count++;
			}
			else {
				count = 1;
				pre = curr;
			}
			if(count > max) {
					max = count;
					answer = curr;
			}
		}
		
		sb.append(answer);
		System.out.println(sb.toString());
	}
	
	public static void main(String args[]) {
		input();
		solution();
	}
}
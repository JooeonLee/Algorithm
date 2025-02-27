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
		
		long nextLong() {
			return Long.parseLong(next());
		}
	}
	
	static class Elem implements Comparable<Elem> {
		int value, idx;
		
		@Override
		public int compareTo(Elem other) {
			if(value != other.value)
				return value - other.value;
			else
				return idx - other.idx;
		}
	}
	
	static int N;
	static Elem[] B;
	static int[] P;
	
	static StringBuilder sb = new StringBuilder();
	
	static void input() {
		FastReader scan = new FastReader();
		
		N = scan.nextInt();
		B = new Elem[N];
		P = new int[N];
		
		for(int i=0; i<N; i++) {
			B[i] = new Elem();
			B[i].idx = i;
			B[i].value = scan.nextInt();
		}
	}
	
	static void solution() {
		Arrays.sort(B);
		
		for(int i=0; i<N; i++) {
			P[B[i].idx] = i;
		}
		
		for(int i=0; i<N; i++)
			sb.append(P[i]).append(' ');
			
		System.out.println(sb.toString());
	}
	
	public static void main(String args[]) {
		input();
		solution();
	}
}
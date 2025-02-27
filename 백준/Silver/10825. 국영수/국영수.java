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
	
	static class Elem implements Comparable<Elem> {
		public String name;
		public int korean, english, math;
		
		@Override
		public int compareTo(Elem other) {
			if(korean != other.korean) 
				return other.korean - korean;
				
			else if(english != other.english)
				return english - other.english;
				
			else if(math != other.math)
				return other.math - math;
			
			else
				return name.compareTo(other.name);
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	static int N;
	static Elem[] a;
	
	static void input() {
		FastReader scan = new FastReader();
		N = scan.nextInt();
		a = new Elem[N];
		
		for(int i=0; i<N; i++) {
			a[i] = new Elem();
			a[i].name = scan.next();
			a[i].korean = scan.nextInt();
			a[i].english = scan.nextInt();
			a[i].math = scan.nextInt();
		}
	}
	
	static void solve() {
		Arrays.sort(a);
		
		for(int i=0; i<a.length; i++) {
		
			sb.append(a[i].name).append('\n');
		}
		System.out.println(sb.toString());
	}
	
	public static void main(String args[]) {
		input();
		solve();
	}
}
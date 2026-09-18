import java.util.*;
import java.io.*;

public class Main {
    static class Task {
        int s;
        int e;
        int c;

        public Task(int s, int e, int c) {
            this.s = s;
            this.e = e;
            this.c = c;
        }
    }
    public static void main(String[] args) {
        // Please write your code here.
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int[] dp = new int[N+1];
        ArrayList<Task> tasks = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            int p = fr.nextInt();
            int c = fr.nextInt();
            Task currTask = new Task(i, i+p-1, c);
            if(i+p-1 <= N)
                tasks.add(currTask);
        }
        tasks.sort((a, b) -> {
            if(a.e != b.e)
                return Integer.compare(a.e, b.e);
            return Integer.compare(b.c, a.c); 
        });

        dp[0] = 0;
        int idx = 0;
        for(int day=1; day<=N; day++) {
            dp[day] = Math.max(dp[day], dp[day-1]);
            
            while(idx < tasks.size() && tasks.get(idx).e == day) {
                Task curr = tasks.get(idx);
                dp[day] = Math.max(dp[day], dp[curr.s-1] + curr.c);
                idx++;
            }
        }
        System.out.println(dp[N]);
    }

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
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
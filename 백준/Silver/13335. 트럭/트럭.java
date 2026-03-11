import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();

        int n = fr.nextInt();
        int w = fr.nextInt();
        int l = fr.nextInt();

        int[] trucks = new int[n];
        for (int i = 0; i < n; i++) {
            trucks[i] = fr.nextInt();
        }

        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            bridge.offer(0);
        }

        int time = 0;
        int idx = 0;
        int bridgeWeight = 0;

        while (idx < n || bridgeWeight > 0) {
            time++;

            bridgeWeight -= bridge.poll();

            if (idx < n && bridgeWeight + trucks[idx] <= l) {
                bridge.offer(trucks[idx]);
                bridgeWeight += trucks[idx];
                idx++;
            } else {
                bridge.offer(0);
            }
        }

        System.out.println(time);
    }

    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws Exception {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws Exception {
            return Integer.parseInt(next());
        }
    }
}
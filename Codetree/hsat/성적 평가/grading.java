import java.util.*;
import java.io.*;

/**
N <= 10^5, N^2으로 안됨

*/
public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        StringBuilder sb = new StringBuilder();

        int n = fr.nextInt();
        int[][] scores = new int[3][n];
        for (int contest = 0; contest < 3; contest++) {
            for (int i = 0; i < n; i++) {
                scores[contest][i] = fr.nextInt();
            }
        }
        // Please write your code here.
        Map<Integer, Integer> srMap0 = new HashMap<>();
        Map<Integer, Integer> srMap1 = new HashMap<>();
        Map<Integer, Integer> srMap2 = new HashMap<>();
        Map<Integer, Integer> srMap3 = new HashMap<>();
        int[] score0 = Arrays.stream(scores[0])
        .boxed()
        .sorted((a, b) -> Integer.compare(b, a))
        .mapToInt(Integer::intValue)
        .toArray();
        int[] score1 = Arrays.stream(scores[1])
        .boxed()
        .sorted((a, b) -> Integer.compare(b, a))
        .mapToInt(Integer::intValue)
        .toArray();
        int[] score2 = Arrays.stream(scores[2])
        .boxed()
        .sorted((a, b) -> Integer.compare(b, a))
        .mapToInt(Integer::intValue)
        .toArray();
        int[] total = new int[n];
        for(int i=0; i<n; i++) {
            total[i] = scores[0][i] + scores[1][i] + scores[2][i];
        }
        int[] score3 = Arrays.stream(total)
        .boxed()
        .sorted((a, b) -> Integer.compare(b, a))
        .mapToInt(Integer::intValue)
        .toArray();

        int rank0 = 1;
        int rank1 = 1;
        int rank2 = 1;
        int rank3 = 1;

        for(int s : score0) {
            if(srMap0.containsKey(s)) {
                rank0++;
                continue;
            }
            srMap0.put(s, rank0);
            rank0++;
        }
        for(int s : score1) {
            if(srMap1.containsKey(s)) {
                rank1++;
                continue;
            }
            srMap1.put(s, rank1);
            rank1++;
        }
        for(int s : score2) {
            if(srMap2.containsKey(s)) {
                rank2++;
                continue;
            }
            srMap2.put(s, rank2);
            rank2++;
        }
        for(int s : score3) {
            if(srMap3.containsKey(s)) {
                rank3++;
                continue;
            }
            srMap3.put(s, rank3);
            rank3++;
        }
        for(int i=0; i<n; i++) {
            sb.append(srMap0.get(scores[0][i])).append(' ');
        }
        sb.append('\n');
        for(int i=0; i<n; i++) {
            sb.append(srMap1.get(scores[1][i])).append(' ');
        }
        sb.append('\n');
        for(int i=0; i<n; i++) {
            sb.append(srMap2.get(scores[2][i])).append(' ');
        }
        sb.append('\n');
        for(int i=0; i<n; i++) {
            sb.append(srMap3.get(total[i])).append(' ');
        }
        sb.append('\n');

        System.out.print(sb);
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
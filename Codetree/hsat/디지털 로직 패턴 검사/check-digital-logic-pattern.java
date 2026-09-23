import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        String S = fr.next();
        int K = fr.nextInt();
        int M = fr.nextInt();
        // Please write your code here.

        HashMap<Integer, Integer> patternMap = new HashMap<>();
        int length = S.length();
        boolean flag = true;

        for (int i = 0; i <= length - K; i++) {
            int bits = 0;
            for (int j = 0; j < K; j++) {
                int bit = S.charAt(i + j) - '0';
                bits |= bit << j;
            }

            int count = patternMap.getOrDefault(bits, 0) + 1;
            if (count >= M) {
                flag = false;
                break;
            }

            patternMap.put(bits, count);
        }

        System.out.println(flag ? 0 : 1);
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
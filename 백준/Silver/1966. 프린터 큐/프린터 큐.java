import java.io.*;
import java.util.*;

public class Main {

    static class FastReader {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = readByte();
            } while (c <= ' ');

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = readByte();
            }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

    static class Doc {
        int idx, pr;
        Doc(int idx, int pr) {
            this.idx = idx;
            this.pr = pr;
        }
    }

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        StringBuilder sb = new StringBuilder();

        int T = fr.nextInt();
        while (T-- > 0) {
            int N = fr.nextInt();
            int M = fr.nextInt();

            Queue<Doc> q = new ArrayDeque<>();
            int[] cnt = new int[10]; 

            for (int i = 0; i < N; i++) {
                int p = fr.nextInt();
                q.offer(new Doc(i, p));
                cnt[p]++;
            }

            int currentMax = 9;
            while (currentMax >= 1 && cnt[currentMax] == 0) currentMax--;

            int printed = 0;

            while (!q.isEmpty()) {
                Doc cur = q.poll();

                if (cur.pr < currentMax) {
                    q.offer(cur);
                    continue;
                }

                printed++;
                cnt[cur.pr]--;

                if (cur.idx == M) {
                    sb.append(printed).append('\n');
                    break;
                }

                while (currentMax >= 1 && cnt[currentMax] == 0) currentMax--;
            }
        }

        System.out.print(sb);
    }
}
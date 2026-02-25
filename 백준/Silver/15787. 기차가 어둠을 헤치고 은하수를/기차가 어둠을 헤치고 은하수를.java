import java.io.*;
import java.util.*;

public class Main {

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

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

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int N = fs.nextInt();
        int M = fs.nextInt();

        int[] train = new int[N + 1];
        int MASK = (1 << 20) - 1;

        for (int m = 0; m < M; m++) {
            int type = fs.nextInt();
            int i = fs.nextInt();

            if (type == 1) {
                int x = fs.nextInt();
                train[i] |= (1 << (x - 1));
            } else if (type == 2) {
                int x = fs.nextInt();
                train[i] &= ~(1 << (x - 1));
            } else if (type == 3) {
                train[i] = (train[i] << 1) & MASK;
            } else { // type == 4
                train[i] >>>= 1;
            }
        }

        HashSet<Integer> seen = new HashSet<>(N * 2);
        for (int i = 1; i <= N; i++) {
            seen.add(train[i]);
        }

        System.out.print(seen.size());
    }
}
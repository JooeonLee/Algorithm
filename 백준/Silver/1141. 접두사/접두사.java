import java.io.*;
import java.util.*;

public class Main {

    static class FastScanner {
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

        String next() throws IOException {
            int c;
            do {
                c = readByte();
                if (c == -1) return null;
            } while (c <= ' ');

            StringBuilder sb = new StringBuilder();
            while (c > ' ') {
                sb.append((char) c);
                c = readByte();
            }
            return sb.toString();
        }

        int nextInt() throws IOException {
            int c;
            do { c = readByte(); } while (c <= ' ');
            int sign = 1;
            if (c == '-') { sign = -1; c = readByte(); }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

    static boolean isPrefixOf(String shortWord, String longWord) {
        if (shortWord.length() > longWord.length()) return false;
        return longWord.startsWith(shortWord);
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int N = fs.nextInt();

        HashSet<String> unique = new HashSet<>(N * 2);
        for (int i = 0; i < N; i++) unique.add(fs.next());

        String[] words = unique.toArray(new String[0]);
        Arrays.sort(words);

        int countPrefixWords = 0;
        for (int i = 0; i < words.length - 1; i++) {
            if (isPrefixOf(words[i], words[i + 1])) {
                countPrefixWords++;
            }
        }

        int answer = words.length - countPrefixWords;
        System.out.println(answer);
    }
}
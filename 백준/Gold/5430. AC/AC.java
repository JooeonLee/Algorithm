import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int T = fr.nextInt();

        while (T-- > 0) {
            String p = fr.next();
            int n = fr.nextInt();
            String arrStr = fr.next();

            Deque<Integer> deque = new LinkedList<>();

            if (n > 0) {
                String arrSubStr = arrStr.substring(1, arrStr.length() - 1);
                String[] arrValue = arrSubStr.split(",");

                for (int i = 0; i < n; i++) {
                    deque.add(Integer.parseInt(arrValue[i]));
                }
            }

            boolean isReversed = false;
            boolean isError = false;

            for (int i = 0; i < p.length(); i++) {
                char cmd = p.charAt(i);

                if (cmd == 'R') {
                    isReversed = !isReversed;
                } else {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }

                    if (isReversed) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }

            if (isError) {
                System.out.println("error");
                continue;
            }

            StringBuilder sb = new StringBuilder();
            sb.append('[');

            while (!deque.isEmpty()) {
                if (isReversed) {
                    sb.append(deque.removeLast());
                } else {
                    sb.append(deque.removeFirst());
                }

                if (!deque.isEmpty()) {
                    sb.append(',');
                }
            }

            sb.append(']');
            System.out.println(sb.toString());
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
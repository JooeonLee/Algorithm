import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        String input = fr.nextLine();

        Stack<Character> stack = new Stack<>();
        int result = 0;
        int temp = 1;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(') {
                stack.push(ch);
                temp *= 2;
            } else if (ch == '[') {
                stack.push(ch);
                temp *= 3;
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    return;
                }

                if (i > 0 && input.charAt(i - 1) == '(') {
                    result += temp;
                }

                stack.pop();
                temp /= 2;
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    return;
                }

                if (i > 0 && input.charAt(i - 1) == '[') {
                    result += temp;
                }

                stack.pop();
                temp /= 3;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(result);
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
            try {
                if (st != null && st.hasMoreTokens()) {
                    StringBuilder sb = new StringBuilder(st.nextToken());
                    while (st.hasMoreTokens()) {
                        sb.append(" ").append(st.nextToken());
                    }
                    return sb.toString();
                }
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
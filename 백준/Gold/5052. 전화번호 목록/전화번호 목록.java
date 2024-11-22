import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {

        solution();
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int t;
    static String[] result;

    static void solution() {
        t = scan.nextInt();
        result = new String[t];

        for(int i=0; i<t; i++) {
            int n = scan.nextInt();
            String[] phoneNumbers = new String[n];

            for(int j=0; j<n; j++) {
                phoneNumbers[j] = scan.nextLine();
            }

            Arrays.sort(phoneNumbers);

            boolean isConsistent = true;
            for(int k=0; k<n-1; k++) {
                if(phoneNumbers[k+1].startsWith(phoneNumbers[k])) {
                    isConsistent = false;
                    break;
                }
            }

            if(isConsistent) {
                sb.append("YES\n");
            }
            else {
                sb.append("NO\n");
            }
        }

        System.out.println(sb);
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
                    st = new StringTokenizer(br.readLine());
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
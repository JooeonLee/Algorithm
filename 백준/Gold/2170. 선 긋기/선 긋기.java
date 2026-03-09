import java.util.*;
import java.io.*;

public class Main {

    static int N;
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        N = fr.nextInt();

        Pair[] pairArr = new Pair[N];

        for(int i=0; i<N; i++) {
            int start = fr.nextInt();
            int end = fr.nextInt();
            pairArr[i] = new Pair(start, end);
        }

        Arrays.sort(pairArr, (a, b) -> {
            if(a.start == b.start)
                return Integer.compare(a.end, b.end);
            return Integer.compare(a.start, b.start);
        });

        int globalEnd = pairArr[0].start;
        int length = 0;
        
        for(int i=0; i<N; i++) {
            int start = pairArr[i].start;
            int end = pairArr[i].end;

            if(globalEnd >= end)
                continue;
            else if(globalEnd >= start) {
                length += end - globalEnd;
                globalEnd = end;
            }
            else {
                length += end - start;
                globalEnd = end;
            }
        }
        
        System.out.println(length);
    }

    static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
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

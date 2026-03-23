import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int N = fr.nextInt();

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

        // int[] result = new int[N];
        // int resultIdx = 0;
        // result[resultIdx++] = pairArr[0].end;
        // for(int i=1; i<N; i++) {
        //     int start = pairArr[i].start;
        //     int end = pairArr[i].end;
        //     int flag = 0;
        //     for(int j=0; j<resultIdx; j++) {
        //         if(result[j] <= start) {
        //             result[j] = end;
        //             flag = 1;
        //             break;
        //         }
        //     }
        //     if(flag == 0) {
        //         result[resultIdx++] = end;
        //     }
        // }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(pairArr[0].end);

        for(int i=1; i<N; i++) {
            if(pq.peek() <= pairArr[i].start) {
                pq.remove();
                pq.offer(pairArr[i].end);
            }
            else
                pq.offer(pairArr[i].end);
        }

        System.out.println(pq.size());
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
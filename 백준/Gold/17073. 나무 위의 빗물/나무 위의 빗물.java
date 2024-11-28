import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        input();
        System.out.println(solution());
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, W;
    static boolean[] check;
    static List<List<Integer>> list = new ArrayList<>();

    static void input() {
        N = scan.nextInt();
        W = scan.nextInt();
        check = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < N-1; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            list.get(u).add(v);
            list.get(v).add(u);
        }
    }

    static double solution() {
        int countLeaf = 0;

        for(int i = 1; i <= N; i++) {
            List<Integer> innerList = list.get(i);
            int edgeNum = innerList.size();
            if(edgeNum == 1 && i != 1)
                countLeaf++;
        }

        return (double) W/countLeaf;
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
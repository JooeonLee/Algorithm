import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
    static FastReader scanner = new FastReader();
    static StringBuilder builder = new StringBuilder();

    static int vertexNum, queryNum;
    static Vector<Integer>[] adjList;
    static Vector<Integer>[] queryList;

    static void input() {
        vertexNum = scanner.nextInt();
        adjList = new Vector[vertexNum+1];

        init_adj_list();
        for (int i = 0; i < vertexNum-1; i++) {
            int num1, num2;
            num1 = scanner.nextInt();
            num2 = scanner.nextInt();
            adjList[num1].add(num2);
            adjList[num2].add(num1);
        }

        queryNum = scanner.nextInt();
        queryList = new Vector[queryNum];
        for (int i = 0; i < queryNum; i++) {
            int queryType = scanner.nextInt();
            if (queryType == 1) {
                queryList[i] = new Vector<>();
                queryList[i].add(1);
                queryList[i].add(scanner.nextInt());
            }
            else if (queryType == 2) {
                queryList[i] = new Vector<>();
                queryList[i].add(2);
                int edgeOrder = scanner.nextInt();
            }
        }
    }

    static void is_cut_vertex_or_bridge() {
        for (int i = 0; i < queryNum; i++) {
            if(queryList[i].get(0) == 1) {
                int edgeCount = adjList[queryList[i].get(1)].size();
                if(edgeCount >= 2) {
                    System.out.println("yes");
                }
                else {
                    System.out.println("no");
                }
            }
            else if(queryList[i].get(0) == 2) {
                System.out.println("yes");
            }
        }
    }

    static void init_adj_list() {
        for (int i = 0; i < vertexNum+1; i++) {
            adjList[i] = new Vector<>();
        }
    }


    public static void main(String[] args) {
        input();
        is_cut_vertex_or_bridge();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
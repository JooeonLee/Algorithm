import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        solution();
    }

    static FastReader scan = new FastReader();

    static int[] preorder;
    static int[] inorder;
    static int[] inorderIndex;

    static void solution() {
        StringBuilder sb = new StringBuilder();

        int T = scan.nextInt();

        while (T-- > 0) {
            int n = scan.nextInt();
            preorder = new int[n];
            inorder = new int[n];
            inorderIndex = new int[n+1];

            StringTokenizer st = new StringTokenizer(scan.nextLine());
            for (int i = 0; i < n; i++) {
                preorder[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(scan.nextLine());
            for (int i = 0; i < n; i++) {
                inorder[i] = Integer.parseInt(st.nextToken());
                inorderIndex[inorder[i]] = i;
            }

            postorder(0, n-1,  0, n-1, sb);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void postorder(int inStart, int inEnd, int preStart, int preEnd, StringBuilder sb) {

        if(inStart > inEnd || preStart > preEnd) {
            return;
        }

        // 현재 서브 트리 루트 (전위순회의 첫번째값)
        int root = preorder[preStart];
        // 중위 순회에서 루트 위치
        int rootIndex = inorderIndex[root];
        // 왼쪽 서브 트리 크기
        int leftSize = rootIndex - inStart;

        // 왼쪽 서브 트리 탐색
        postorder(inStart, rootIndex-1, preStart+1, preStart+leftSize, sb);

        // 오른쪽 서브 트리 탐색
        postorder(rootIndex+1, inEnd, preStart+leftSize+1, preEnd, sb);

        // 현재 루트 탐색
        sb.append(root).append(" ");

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
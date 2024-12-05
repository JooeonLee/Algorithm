import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
        left = right = null;
    }
}

class BST {
    Node root;

    public void insert(int value) {
        root = insertRecur(root, value);
    }

    private Node insertRecur(Node node, int value) {
        if(node == null) {
            return new Node(value);
        }
        if(value < node.value) {
            node.left = insertRecur(node.left, value);
        }
        else if(value > node.value) {
            node.right = insertRecur(node.right, value);
        }
        return node;
    }

    public void postOrderTraversal() {
        postOrderRecur(root);
    }

    private void postOrderRecur(Node node) {
        if(node != null) {
            postOrderRecur(node.left);
            postOrderRecur(node.right);
            System.out.println(node.value);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BST bst = new BST();
        input(bst);
        bst.postOrderTraversal();
    }

    static FastReader scan = new FastReader();

    static void input(BST bst) {
        while(true) {
            String line = scan.nextLine();
            if(line == null || line.isEmpty()) {
                break;
            }
            bst.insert(Integer.parseInt(line));
        }
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
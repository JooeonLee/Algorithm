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
    public static void main(String[] args) throws IOException {
        BST bst = new BST();
        input(bst);
        bst.postOrderTraversal();
    }


    static void input(BST tree) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";

        StringBuilder sb = new StringBuilder();
        while((s = br.readLine()) != null && !s.isEmpty()) {
            StringTokenizer st = new StringTokenizer(s);
            int num = Integer.parseInt(st.nextToken());
            tree.insert(num);
        }
    }

    static void solution() {

    }
}
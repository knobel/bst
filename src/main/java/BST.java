import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by michal on 05.01.17.
 */
public class BST {

    Node root;

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        Node cur;
        if (value <= node.value) {
            cur = insert(node.left, value);
            node.left = cur;
        } else {
            cur = insert(node.right, value);
            node.right = cur;
        }
        return node;

    }

    public void insert(int value) {
        root = insert(root, value);
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node node) {
        if (node == null) return 0;

        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public int getLongestPath() {

        return getLongestPath(root);
    }

    private int getLongestPath(Node node) {
        if (node == null) return 1;
        return Math.max(getHeight(node.right) + getHeight(node.left) + 1,
                Math.max(getLongestPath(node.left),
                        getLongestPath(node.right)));
    }

    public void printTree(OutputStreamWriter outputStreamWriter) throws IOException {
        root.printTree(outputStreamWriter);
    }

    private String levelOrder(Node node) {
//        if (node == null) return "";
//        return node.value + " " + levelOrder(node.left) + levelOrder(node.right);

        String result = "";

        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            result += current.value + " ";
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        System.out.println(result);
        return result;
    }

    public String levelOrder() {
        return levelOrder(root);
    }

}

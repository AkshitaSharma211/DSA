class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class LargestBSTInBinaryTree {

    static class Info {
        int size;      // Size of subtree
        int min;       // Minimum value in subtree
        int max;       // Maximum value in subtree
        int largestBST; // Largest BST size found so far
        boolean isBST;

        Info(int size, int min, int max, int largestBST, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.largestBST = largestBST;
            this.isBST = isBST;
        }
    }

    static Info largestBSTUtil(Node root) {

        // Empty tree is BST
        if (root == null) {
            return new Info(
                    0,
                    Integer.MAX_VALUE,
                    Integer.MIN_VALUE,
                    0,
                    true
            );
        }

        // Leaf node is BST
        if (root.left == null && root.right == null) {
            return new Info(
                    1,
                    root.data,
                    root.data,
                    1,
                    true
            );
        }

        Info left = largestBSTUtil(root.left);
        Info right = largestBSTUtil(root.right);

        int size = left.size + right.size + 1;

        // Check BST property
        if (left.isBST &&
            right.isBST &&
            root.data > left.max &&
            root.data < right.min) {

            int min = Math.min(root.data, left.min);
            int max = Math.max(root.data, right.max);

            return new Info(
                    size,
                    min,
                    max,
                    size,
                    true
            );
        }

        return new Info(
                size,
                Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                Math.max(left.largestBST, right.largestBST),
                false
        );
    }

    static int largestBST(Node root) {
        return largestBSTUtil(root).largestBST;
    }

    public static void main(String[] args) {

        /*
                 50
               /    \
             30      60
            /  \    /  \
           5   20  45   70
                        / \
                       65 80

           Largest BST Size = 5
        */

        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(60);

        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right.left = new Node(45);
        root.right.right = new Node(70);

        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        System.out.println("Largest BST Size = " + largestBST(root));
    }
}
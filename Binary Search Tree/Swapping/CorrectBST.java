class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}

public class CorrectBST {

    TreeNode first, middle, last, prev;

    public void correctBST(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);

        inorder(root);

        // Non-adjacent swapped nodes
        if (first != null && last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }
        // Adjacent swapped nodes
        else if (first != null && middle != null) {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);

        if (prev != null && root.data < prev.data) {

            // First violation
            if (first == null) {
                first = prev;
                middle = root;
            }
            // Second violation
            else {
                last = root;
            }
        }

        prev = root;

        inorder(root.right);
    }

    public void printInorder(TreeNode root) {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {

        /*
                6
               / \
             10   2
            / \  / \
           1  3 7 12

           Swapped nodes: 10 and 2
        */

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(10);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(12);

        CorrectBST tree = new CorrectBST();

        System.out.println("Inorder before correction:");
        tree.printInorder(root);

        tree.correctBST(root);

        System.out.println("\nInorder after correction:");
        tree.printInorder(root);
    }
}
// Lowest Common Ancestor (LCA) in Binary Search Tree (BST)

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class LCAInBST {

    // Function to find LCA in BST
    public static TreeNode findLCA(TreeNode root, int n1, int n2) {

        if (root == null)
            return null;

        // If both nodes are smaller than root, move to left subtree
        if (n1 < root.data && n2 < root.data)
            return findLCA(root.left, n1, n2);

        // If both nodes are greater than root, move to right subtree
        if (n1 > root.data && n2 > root.data)
            return findLCA(root.right, n1, n2);

        // Current node is the LCA
        return root;
    }

    public static void main(String[] args) {

        /*
                  20
                /    \
              10      30
             /  \    /  \
            5   15  25  35
        */

        TreeNode root = new TreeNode(20);

        root.left = new TreeNode(10);
        root.right = new TreeNode(30);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);

        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);

        int n1 = 5;
        int n2 = 15;

        TreeNode lca = findLCA(root, n1, n2);

        if (lca != null)
            System.out.println("LCA of " + n1 + " and " + n2 + " is: " + lca.data);
        else
            System.out.println("LCA not found");
    }
}

import java.util.*;

public class BinaryTree {

    // Root of Binary Tree
    TreeNode root;

    BinaryTree()
    {
        root = null;
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        /*
        // Recursive Method
        List<Integer> tree = new ArrayList<Integer>();
        if (root != null){
            tree.add(root.val);
            tree.addAll(preorderTraversal(root.left));
            tree.addAll(preorderTraversal(root.right));
        }
        return tree;
        */

        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return result;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
       /*
        // Recursive Method
        List<Integer> tree = new ArrayList<Integer>();
        if (root != null){
            tree.addAll(inorderTraversal(root.left));
            tree.add(root.val);
            tree.addAll(inorderTraversal(root.right));
        }
        return tree;
        */

        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        /*
        // Recursive Method
        List<Integer> tree = new ArrayList<Integer>();
        if (root != null){
            tree.addAll(postorderTraversal(root.left));
            tree.addAll(postorderTraversal(root.right));
            tree.add(root.val);
        }
        return tree;

        */
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(0, curr.val);
            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }
        return result;
    }

    // Given a binary tree, return the level order traversal of its nodes' values.
    // (ie, from left to right, level by level).
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root == null)
            return result;
        Queue<TreeNode> que = new LinkedList();
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> level = new ArrayList();
            while(size>0){
                // The poll() method of Queue Interface returns and removes the element at the front the container.
                TreeNode node = que.poll();
                level.add(node.val);
                if(node.left != null)
                    que.add(node.left);
                if(node.right != null)
                    que.add(node.right);
                size--;
            }
            result.add(level);
        }
        return result;
    }

    /*Given a binary tree, print out all of its root-to-leaf
      paths, one per line. Uses a recursive helper to do
      the work.*/
    void printPaths(TreeNode node)
    {
        int path[] = new int[1000];
        printPathsRecur(node, path, 0);
    }

    /* Recursive helper function -- given a node, and an array
       containing the path from the root node up to but not
       including this node, print out all the root-leaf paths.*/
    void printPathsRecur(TreeNode node, int path[], int pathLen)
    {
        if (node == null)
            return;

        /* append this node to the path array */
        path[pathLen] = node.val;
        pathLen++;

        /* it's a leaf, so print the path that led to here  */
        if (node.left == null && node.right == null)
            printArray(path, pathLen);
        else
        {
            /* otherwise try both subtrees */
            printPathsRecur(node.left, path, pathLen);
            printPathsRecur(node.right, path, pathLen);
        }
    }

    /* Utility function that prints out an array on a line. */
    void printArray(int ints[], int len)
    {
        int i;
        for (i = 0; i < len; i++)
        {
            System.out.print(ints[i] + " ");
        }
        System.out.println();
    }

    // Given a binary tree, find its maximum depth.
    //The maximum depth is the number of nodes along the longest path from the root node down
    // to the farthest leaf node.
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
    public static boolean isSymmetric(TreeNode root) {
        return root==null || isSymmetricChecker(root.left, root.right);
    }

    private static boolean isSymmetricChecker(TreeNode left, TreeNode right){
        if(left==null || right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return isSymmetricChecker(left.left, right.right) && isSymmetricChecker(left.right, right.left);
    }

    // Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all
    // the values along the path equals the given sum.
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;

        if(root.left == null && root.right == null)
            return  root.val == sum;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    // Given inorder and postorder traversal of a tree, construct the binary tree.
    // Assume no duplicates in a tree
    public static TreeNode buildTree(int[] in, int[] post) {
        if (in == null || in.length == 0 || post == null || post.length == 0) { return null; }
        return helper(post, post.length - 1, in, 0, in.length - 1);
    }
    private static TreeNode helper(int[] post, int idx, int[] in, int start, int end) {
        if (start > end || idx < 0) { return null; }
        TreeNode root = new TreeNode(post[idx]);
        int i;
        for (i = start; i <= end; i++) {
            if (in[i] == root.val) {
                break;
            }
        }
        root.right = helper(post, idx - 1, in, i + 1, end);
        root.left = helper(post, idx - (end - i  + 1), in, start, i - 1);
        return root;
    }

    // sorted Array to Binary Search Tree
    public static TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        TreeNode head = helper(num, 0, num.length - 1);
        return head;
    }

    public static TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }

    // Check if it is a valid Binary Search Tree
    public static boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val)
                return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        List<Integer> result1, result2, result3, result5;
        List<List<Integer>> result4;

        result1 = preorderTraversal(tree.root);
        System.out.println("Preorder traversal of binary tree is ");
        System.out.print(result1);

        result2 = inorderTraversal(tree.root);
        System.out.println("\nInorder traversal of binary tree is ");
        System.out.print(result2);

        result3 = postorderTraversal(tree.root);
        System.out.println("\nPostorder traversal of binary tree is ");
        System.out.print(result3);

        result4 = levelOrder(tree.root);
        System.out.println("\nLevel Order traversal of binary tree is ");
        System.out.print(result4);

        int maxDepth;
        maxDepth = maxDepth(tree.root);
        System.out.println("\nMax Depth of the Tree: ");
        System.out.print(maxDepth);

        BinaryTree tree1 = new BinaryTree();
        tree1.root = new TreeNode(1);
        tree1.root.left = new TreeNode(2);
        tree1.root.right = new TreeNode(2);
        tree1.root.left.left = new TreeNode(3);
        tree1.root.left.right = new TreeNode(4);
        tree1.root.right.left = new TreeNode(4);
        tree1.root.right.right = new TreeNode(3);

        boolean sym;
        sym = isSymmetric(tree1.root);
        System.out.printf("\nIs symmetric? : %b", sym);
        System.out.println();

        boolean sum;
        int n = 6;
        sum = hasPathSum(tree1.root, n);
        System.out.printf("\nCheck if it has sum %d ? : %b", n, sum);
        System.out.println();


        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        BinaryTree tree2 = new BinaryTree();
        tree2.root = new TreeNode ();
        tree2.root = buildTree(inorder, postorder);
       // tree2.printPaths(tree2.root);

        int[] sortedArray = {-10,-3,0,5,9};
        BinaryTree tree3 = new BinaryTree();
        tree3.root = new TreeNode ();
        tree3.root = sortedArrayToBST(sortedArray);
        result5 = inorderTraversal(tree3.root);
        System.out.println("\nInorder traversal of binary search tree is ");
        System.out.print(result5);

        boolean isBST;
        isBST = isValidBST(tree3.root);
        System.out.printf("\nIs valid BST? : %b", isBST);
        System.out.println();
    }
}

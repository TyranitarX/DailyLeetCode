public class E104_maxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftmax = maxDepth(root.left) + 1;
        int rightmax = maxDepth(root.right) + 1;
        return Math.max(leftmax, rightmax);
    }
}

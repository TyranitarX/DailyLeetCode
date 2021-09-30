package byteDance;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/25 17:03
 **/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class H124_maxPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getmaxgain(root);
        return max;
    }

    public int getmaxgain(TreeNode root) {
        if (root == null)
            return 0;
        int leftgain = getmaxgain(root.left);
        int rightgain = getmaxgain(root.right);
        int nowleft = Math.max(leftgain, 0);
        int nowright = Math.max(rightgain, 0);
        max = Math.max(root.val + nowleft + nowright, max);

        return root.val + Math.max(leftgain, rightgain);
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(-1);

        System.out.println(new H124_maxPathSum().maxPathSum(treeNode));
    }
}

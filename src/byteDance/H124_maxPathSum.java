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

        int maxgain = root.val + Math.max(leftgain, rightgain);
        int maxcur = root.val;
        maxcur = leftgain > 0 ? maxcur + leftgain : maxcur;
        maxcur = rightgain > 0 ? maxcur + rightgain : maxcur;
        max = Math.max(max, maxcur);
        return maxgain;
    }
}

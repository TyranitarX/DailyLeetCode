package M_129;

public class M129_sumNumbers {
    int total = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        StringBuffer now = new StringBuffer();
        bfs(root, now);
        return total;
    }

    public void bfs(TreeNode root, StringBuffer now) {
        now.append(root.val);
        if (root.left == null && root.right == null) {
            total += Integer.parseInt(now.toString());
            return;
        }
        StringBuffer local = new StringBuffer(now);
        if (root.left != null)
            bfs(root.left, now);
        if (root.right != null)
            bfs(root.right, local);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        System.out.println(new M129_sumNumbers().sumNumbers(root));
    }
}

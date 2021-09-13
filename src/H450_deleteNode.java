/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/11 16:28
 **/
public class H450_deleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            TreeNode rightnode = root.right;
            while (rightnode.left != null) {
                rightnode = rightnode.left;
            }
            rightnode.left = root.left;
            root = root.right;
        }
        return root;
    }
}

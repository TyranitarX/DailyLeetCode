package byteDance;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/28 21:34
 **/
public class M105_buildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeeee(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTreeeee(int[] preorder, int[] inorder, int start_pre, int end_pre, int start_in, int end_in) {
        if (start_pre == end_pre)
            return new TreeNode(preorder[start_pre]);
        int rootval = preorder[start_pre];
        TreeNode root = new TreeNode(rootval);
        int rootinorder = 0;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootval) {
                rootinorder = i;
                break;
            }
        }

        int leftnum = rootinorder - start_in;
        if (rootinorder - 1 >= start_in)
            root.left = buildTreeeee(preorder, inorder, start_pre + 1, start_pre + leftnum, start_in, rootinorder - 1);
        if (rootinorder + 1 <= end_in)
            root.right = buildTreeeee(preorder, inorder, start_pre + leftnum + 1, end_pre, rootinorder + 1, end_in);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {1, 2, 3, 4};
        System.out.println(new M105_buildTree().buildTree(preorder, inorder));
    }
}

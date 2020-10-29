public class E617_mergeTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode treeNode = null;
        if (t1 != null && t2 != null){
            treeNode = new TreeNode(t1.val + t2.val);
            treeNode.left=merge(treeNode.left,t1.left,t2.left);
            treeNode.right=merge(treeNode.right,t1.right,t2.right);
        }
        if (t1 != null && t2 == null){
            treeNode = new TreeNode(t1.val);
            treeNode.left=merge(treeNode.left,t1.left,null);
            treeNode.right=merge(treeNode.right,t1.right,null);
        }
        if (t1 == null && t2 != null){
            treeNode = new TreeNode(t2.val);
            treeNode.left=merge(treeNode.left,null,t2.left);
            treeNode.right=merge(treeNode.right,null,t2.right);
        }
        if (t1 == null && t2 == null)
            return null;
        return treeNode;
    }
    public TreeNode merge(TreeNode merge, TreeNode t1, TreeNode t2){
        if (t1 != null && t2 != null){
            merge = new TreeNode(t1.val + t2.val);
            merge.left=merge(merge.left,t1.left,t2.left);
            merge.right=merge(merge.right,t1.right,t2.right);
        }
        if (t1 != null && t2 == null){
            merge = new TreeNode(t1.val);
            merge.left=merge(merge.left,t1.left,null);
            merge.right=merge(merge.right,t1.right,null);
        }
        if (t1 == null && t2 != null){
            merge = new TreeNode(t2.val);
            merge.left=merge(merge.left,null,t2.left);
            merge.right=merge(merge.right,null,t2.right);
        }
        return merge;
    }

}

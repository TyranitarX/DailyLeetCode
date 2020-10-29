import java.util.ArrayList;
import java.util.List;

public class E501_findMode {
    List<Integer> mList = new ArrayList<>();
    int curent = 0;
    int count = 0;
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        midroute(root);
        int out[]=new int[mList.size()];
        for(int i=0;i<mList.size();i++){
            out[i] =mList.get(i);
        }
        return out;
    }

    public void midroute(TreeNode root) {
        if (root == null)
            return ;
        int nodeval =root.val;
        midroute(root.left);
        if(nodeval==curent){
            count++;
        }else {
            curent = nodeval;
            count = 1;
        }
        if(count==maxCount){
            mList.add(nodeval);
        }else if(count>maxCount){
            mList.clear();
            mList.add(nodeval);
            maxCount=count;
        }
        midroute(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(2);
        System.out.println(new E501_findMode().findMode(root));
    }
}

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/9 10:19
 **/
public class M230_kthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            count++;
            if(count==k)
                return root.val;
            root = root.right;
        }
        return -1;
    }
}

public class Offer33_verifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        return isPostOrder(postorder, 0, postorder.length - 1);
    }

    public boolean isPostOrder(int[] postorder, int s, int e) {
        if (s >= e)
            return true;
        int q = s;
        while (postorder[q] < postorder[e]) q++;
        int k = q;
        while (postorder[k] > postorder[e]) k++;
        return k == e && isPostOrder(postorder, s, q - 1) && isPostOrder(postorder, q, k - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 6, 5};
        System.out.println(new Offer33_verifyPostorder().verifyPostorder(nums));
    }
}

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/4/19 8:44
 **/
public class E27_removeElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] == val) {
                if (n - (i + 1) >= 0) System.arraycopy(nums, i + 1, nums, i, n - (i + 1));
                n--;
            } else
                i++;
        }
        return n;
    }

    public static void main(String[] args) {
        int nums[] = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(new E27_removeElement().removeElement(nums, 2));
    }
}

import java.util.Arrays;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/27 17:39
 * <p>
 * 摩尔投票法！
 **/
public class E169_majorityElement {
    public int majorityElement(int[] nums) {
        int cur = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cur)
                count++;
            else
                count--;
            if (count == 0) {
                cur = nums[i];
                count = 1;
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(new E169_majorityElement().majorityElement(nums));
    }
}

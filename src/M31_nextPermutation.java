import java.util.Arrays;

/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 解法：找到一个数nums[k]<nums[k+1],k尽可能大 如不存在则为最大序列 直接整个反转
 *       找到一个数l 使得 nums[l]>nums[k]
 *       将找到的较小数与交大数交换 这时 k+1~length-1 为倒序 将其反转得到下一个排列
 */
public class M31_nextPermutation {
    public void nextPermutation(int[] nums) {
        int k = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                k = i - 1;
            }
        }
        if (k == -1) {
            reverse(nums, 0);
            return;
        }
        int l = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[k])
                l = i;
        }
        swap(nums, k, l);
        reverse(nums, k + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        new M31_nextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}

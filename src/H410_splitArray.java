/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/10 10:35
 *
 *  二分系列
 *  「力扣」第 875 题：爱吃香蕉的珂珂（中等）
 *  LCP 12. 小张刷题计划 （中等）
 *  「力扣」第 1482 题：制作 m 束花所需的最少天数（中等）
 *  「力扣」第 1011 题：在 D 天内送达包裹的能力（中等）
 *  「力扣」第 1552 题：两球之间的磁力（中等）
 *
 **/
public class H410_splitArray {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int min = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            min = Math.max(min, nums[i]);
            max += nums[i];
        }
        int left = min;
        int right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int splits = split(nums, mid);
            if (splits > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int split(int[] nums, int maxNums) {
        int split = 1;
        int curmax = 0;
        for (int num : nums) {
            if (curmax + num > maxNums) {
                curmax = 0;
                split++;
            }
            curmax += num;
        }
        return split;
    }
}

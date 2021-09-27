package byteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M15_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int m = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < m - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int target = -nums[i];
            int last = m - 1;
            for (int j = i + 1; j < m - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                if (j == last) {
                    break;
                }
                if (nums[j] + nums[last] == target) {
                    List<Integer> array = new ArrayList<>();
                    array.add(nums[i]);
                    array.add(nums[j]);
                    array.add(nums[last]);
                    res.add(array);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new M15_threeSum().threeSum(nums));
    }
}

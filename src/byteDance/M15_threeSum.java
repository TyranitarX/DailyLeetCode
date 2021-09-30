package byteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M15_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int end = nums.length - 1;
            int target = -nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                while (j < end && nums[j] + nums[end] > target)
                    end--;
                if (j == end)
                    break;
                if (nums[j] + nums[end] == target) {
                    List<Integer> resarr = new ArrayList<>();
                    resarr.add(nums[i]);
                    resarr.add(nums[j]);
                    resarr.add(nums[end]);
                    res.add(resarr);
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

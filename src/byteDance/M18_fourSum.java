package byteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M18_fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int m = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue;
            int rest3 = target - nums[i];
            for (int j = i + 1; j < m - 2; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j])
                    continue;
                int rest2 = rest3 - nums[j];
                int last = m - 1;
                for (int k = j + 1; k < m - 1; k++) {
                    if (k > j + 1 && nums[k - 1] == nums[k])
                        continue;
                    while (k < last && nums[last] + nums[k] > rest2)
                        last--;
                    if (last == k)
                        break;
                    if (nums[last] + nums[k] == rest2) {
                        List<Integer> array = new ArrayList<>();
                        array.add(nums[i]);
                        array.add(nums[j]);
                        array.add(nums[k]);
                        array.add(nums[last]);
                        res.add(array);
                    }
                    last = m - 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(new M18_fourSum().fourSum(nums, target));
    }
}

package byteDance;

import java.util.ArrayList;
import java.util.List;

public class M300_lengthOfLIS {
    public List<Integer> lengthOfLIS(int[] nums) {
        List<Integer>[] dp = new ArrayList[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = new ArrayList<>();
            dp[i].add(nums[i]);
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] + 1 == nums[i]) {
                    if (dp[j].size() + 1 > dp[i].size()) {
                        dp[i] = dp[j];
                        dp[i].add(nums[i]);
                    }
                }
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 4, 3, 7, 101, 5};
        System.out.println(new M300_lengthOfLIS().lengthOfLIS(nums));
    }
}

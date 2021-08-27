import java.util.Arrays;

public class M300_lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int[] dp = new int[n];
        int[] preindex = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(preindex, -1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    preindex[i] = (dp[j] + 1 > dp[i]) ? j : preindex[i];
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        int maxi = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                maxi = i;
                max = dp[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        while (maxi != -1) {
            sb.insert(0, nums[maxi] + " ");
            maxi = preindex[maxi];
        }
        System.out.println(sb.toString().trim());
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new M300_lengthOfLIS().lengthOfLIS(nums));
    }
}

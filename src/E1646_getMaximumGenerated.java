import java.util.Arrays;

public class E1646_getMaximumGenerated {
    public int getMaximumGenerated(int n) {
        if (n == 0)
            return 0;
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                nums[i] = nums[i / 2];
            } else {
                nums[i] = nums[i / 2] + nums[i / 2 + 1];
            }
        }
        return Arrays.stream(nums).max().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(new E1646_getMaximumGenerated().getMaximumGenerated(7));
    }
}

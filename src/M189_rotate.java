import java.util.Arrays;

public class M189_rotate {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int i = 0;
        int start = 0;
        int now = nums[0];
        while (count < n) {
            i = (i + k) % n;
            int temp = now;
            now = nums[i];
            nums[i] = temp;
            count++;
            if (i == start) {
                i = start = (i + 1) % n;
                now = nums[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        new M189_rotate().rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
}

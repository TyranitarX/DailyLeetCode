public class M213_rob {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length > 1) {
            int[] res1 = doRob(nums, 0, nums.length - 2);
            int[] res2 = doRob(nums, 1, nums.length - 1);
            return Math.max(Math.max(res1[0], res1[1]), Math.max(res2[0], res2[1]));
        } else
            return nums[0];
    }

    public int[] doRob(int[] nums, int start, int end) {
        if (nums.length == 0)
            return new int[2];
        if (end < start)
            return new int[2];
        int result[] = new int[2];
        int next[] = doRob(nums, start + 1, end);
        result[0] = Math.max(next[0], next[1]);
        result[1] = nums[start] + next[0];
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new M213_rob().rob(nums));
    }
}

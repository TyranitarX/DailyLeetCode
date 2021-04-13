public class M153_findMin {
    public int findMin(int[] nums) {
        int n = nums.length;
        int i = 1;
        while (i < n && nums[i] > nums[i - 1])
            i++;

        return i < n ? nums[i] : nums[0];
    }

    public static void main(String[] args) {

    }
}

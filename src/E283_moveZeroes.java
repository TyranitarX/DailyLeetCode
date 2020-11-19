public class E283_moveZeroes {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = left + 1;
        while (right < nums.length) {
            if (nums[left] == 0 && nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            if (nums[left] != 0) left++;
            right++;
        }
    }
}
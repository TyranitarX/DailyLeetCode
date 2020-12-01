import com.sun.scenario.effect.Reflection;

public class M34_searchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                int j = mid;
                while (j >= 0 && nums[j] == target)
                    j--;
                range[0] = j + 1;
                j = mid;
                while (j < nums.length && nums[j] == target)
                    j++;
                range[1] = j - 1;
                break;
            }
        }
        return range;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 6, 7, 7, 7, 7, 8, 8, 10};
        int[] range = new M34_searchRange().searchRange(nums, 7);
        System.out.println(range[0]);
        System.out.println(range[1]);
    }
}

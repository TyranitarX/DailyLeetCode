import java.util.Arrays;

public class quickSort {
    public void quick_sort(int nums[], int s, int e) {
        if (s >= e)
            return;
        int i = s, j = e, x = nums[s];
        while (i < j) {
            while (i < j && nums[j] >= x)
                j--;
            if (i < j)
                nums[i] = nums[j];
            while (i < j && nums[i] <= x)
                i++;
            if (i < j)
                nums[j] = nums[i];
        }
        nums[i] = x;
        quick_sort(nums, s, i - 1);
        quick_sort(nums, i + 1, e);
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4, 5, 7, 9, 1};
        quickSort quickSort = new quickSort();
        quickSort.quick_sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(Arrays.stream(nums).
                toArray()));
    }
}

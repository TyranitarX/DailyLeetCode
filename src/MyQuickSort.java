import java.util.Arrays;

public class MyQuickSort {
    public void quicksort(int[] nums, int s, int e) {
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
        quicksort(nums, s, i - 1);
        quicksort(nums, i + 1, e);
    }

    public static void main(String[] args) {
        int[] i = {2, 3, 5, 1, 0, -1};
        new MyQuickSort().quicksort(i, 0, i.length - 1);
        System.out.println(Arrays.toString(i));
    }
}

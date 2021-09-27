package byteDance;

import java.util.Arrays;

public class Adjustoddeven {
    public int[] adjust(int[] ori) {
        int i = 0;
        int j = 1;
        while (i < ori.length && j < ori.length) {
            int ready = ori[ori.length - 1];
            if (ready % 2 == 0) {
                swap(ori, i, ori.length - 1);
                i += 2;
            } else {
                swap(ori, j, ori.length - 1);
                j += 2;
            }
        }
        return ori;
    }

    public void swap(int[] ori, int i, int j) {
        int temp = ori[i];
        ori[i] = ori[j];
        ori[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(new Adjustoddeven().adjust(nums)));
    }
}

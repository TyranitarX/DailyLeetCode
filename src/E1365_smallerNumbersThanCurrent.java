import java.util.*;

public class E1365_smallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] orinum = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        List list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        int[] smallnums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            smallnums[i] = list.indexOf(orinum[i]);
        }
        return smallnums;
    }

    public static void main(String[] args) {
        int[] x = {2, 2, 8, 1, 4};
        int[] result = new E1365_smallerNumbersThanCurrent().smallerNumbersThanCurrent(x);
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);
        System.out.println(result[4]);
    }

}

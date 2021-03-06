import java.util.Arrays;
import java.util.Stack;

public class M503_nextGreaterElements {
    /**
     * 垃圾暴力
     */
//    public int[] nextGreaterElements(int[] nums) {
//        int[] nextGreaterlist = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            int j = (i + 1) % nums.length;
//            while (j != i) {
//                if (nums[j] > nums[i]) {
//                    nextGreaterlist[i] = nums[j];
//                    break;
//                }
//                j = (j + 1) % nums.length;
//            }
//            if (j == i)
//                nextGreaterlist[i] = -1;
//        }
//        return nextGreaterlist;
//    }

    /**
     * 单调栈
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] nextGreaterlist = new int[nums.length];
        Stack<Integer> downstack = new Stack<>();
        Arrays.fill(nextGreaterlist, -1);
        for (int i = 0; i < 2 * nums.length; i++) {
            while (!downstack.empty() && nums[i % nums.length] > nums[downstack.peek()]) {
                nextGreaterlist[downstack.pop()] = nums[i % nums.length];
            }
            downstack.push(i % nums.length);
        }
        return nextGreaterlist;
    }
}

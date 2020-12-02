import java.util.*;

public class H321_maxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        k = nums1.length + nums2.length - k;
        String max = "0";
        for (int i = 0; i <= k; i++) {
            if (i > nums1.length || k - i > nums2.length)
                continue;
            int len1 = i;
            int len2 = k - i;
            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            for (int j = 0; j < nums1.length; j++) {
                while (!stack1.empty() && stack1.peek() < nums1[j] && len1 > 0) {
                    stack1.pop();
                    len1--;
                }
                stack1.push(nums1[j]);
            }
            while (len1 > 0) {
                stack1.pop();
                len1--;
            }
            for (int l = 0; l < nums2.length; l++) {
                while (!stack2.empty() && stack2.peek() < nums2[l] && len2 > 0) {
                    stack2.pop();
                    len2--;
                }
                stack2.push(nums2[l]);
            }
            while (len2 > 0) {
                stack2.pop();
                len2--;
            }
            String maxnow = mergemax(stack1, stack2);
            max = max.compareTo(maxnow) > 0 ? max : maxnow;
        }
        System.out.println(max);
        int[] x = new int[max.length()];
        for (int i = 0; i < x.length; i++) {
            x[i] = (max.charAt(i) - '0');
        }
        return x;
    }

    public String mergemax(Stack<Integer> stack1, Stack<Integer> stack2) {
        int i = 0;
        int j = 0;
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> list1 = new ArrayList<>(stack1);
        List<Integer> list2 = new ArrayList<>(stack2);
        while (i < list1.size() || j < list2.size()) {
            if (Compare(list1, list2, i, j) > 0) {
                stringBuilder.append(list1.get(i));
                i++;
            } else {
                stringBuilder.append(list2.get(j));
                j++;
            }
        }
        return stringBuilder.toString();
    }

    public int Compare(List<Integer> list1, List<Integer> list2, int i, int j) {
        while (i < list1.size() && j < list2.size()) {
            int a = list1.get(i);
            int b = list2.get(j);
            if (a != b)
                return a - b;
            i++;
            j++;
        }
        return (list1.size() - i) - (list2.size() - j);
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        System.out.println(new H321_maxNumber().maxNumber(nums1, nums2, 5));
    }
}

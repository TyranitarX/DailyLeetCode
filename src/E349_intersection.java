import java.util.*;

public class E349_intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0)
            return new int[0];
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        for (int num1 : nums1)
            set1.add(num1);
        for (int num2 : nums2)
            set2.add(num2);
        Iterator<Integer> it = set1.iterator();
        while (it.hasNext()) {
            int now = it.next();
            if (set2.contains(now))
                set3.add(now);
        }
        int[] result = new int[set3.size()];
        it = set3.iterator();
        int i = 0;
        while (it.hasNext()) {
            result[i] = it.next();
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1};
        int[] b = {2, 2};
        System.out.println(Arrays.toString(new E349_intersection().intersection(a, b)));
    }
}

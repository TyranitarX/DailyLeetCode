package NIOCar;

import java.util.Arrays;

public class Course1 {
    public int firstMissingPositive(int[] A) {
        // write code here
        int n = A.length;
        int pre = 0;
        Arrays.sort(A);
        for (int i = 0; i < n; i++) {
            if (A[i] > 0) {
                if (pre == 0) {
                    if (A[i] != 1)
                        return 1;
                    pre = A[i];
                } else {
                    if (A[i] == pre + 1) {
                        pre = A[i];
                    } else {
                        return pre + 1;
                    }
                }
            }
        }
        return A[A.length - 1] > 0 ? A[A.length - 1] + 1 : 1;
    }

    public static void main(String[] args) {
        int[] nums = {-100000,0,1,2,3,4,5,7,8,9};
        System.out.println(new Course1().firstMissingPositive(nums));
    }
}

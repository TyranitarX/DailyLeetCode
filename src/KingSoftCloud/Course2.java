package KingSoftCloud;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Course2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] numss = in.nextLine().split(" ");
        Map<String,String> mymap =new HashMap<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(numss[i]);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[k] > nums[j] && nums[j] > nums[i]) {
                        max = Math.max(max, nums[k] + nums[j] + nums[i]);
                    }
                }
            }
        }
        System.out.println(max);
    }
}

package bilibili20201;

import java.util.Arrays;
import java.util.Scanner;


public class Course2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] nums = in.nextLine().split(",");
        Arrays.sort(nums, (num1, num2) -> (num1 + num2).compareTo((num2 + num1)));
        System.out.println(String.join("", nums));
    }
}

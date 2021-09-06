package bilibili202101;

import java.util.ArrayList;
import java.util.List;

/**
 * 0.99循环====1？
 */
public class Game24Points {
    public boolean Game24Points(int[] arr) {
        List<Double> nums = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            nums.add(arr[i] + 0.0d);
        }
        return solve(nums);
    }

    public boolean solve(List<Double> nums) {
        if (nums.size() == 1) {
            return nums.get(0) == 24d;
        }
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i != j) {
                    List<Double> list2 = new ArrayList<Double>();
                    for (int k = 0; k < nums.size(); k++) {
                        if (k != i && k != j) {
                            list2.add(nums.get(k));
                        }
                    }
                    double num1 = nums.get(i);
                    double num2 = nums.get(j);
                    list2.add(num1 + num2);
                    if (solve(list2)) return true;
                    list2.remove(list2.size() - 1);
                    list2.add(num1 - num2);
                    if (solve(list2)) return true;
                    list2.remove(list2.size() - 1);
                    list2.add(num1 * num2);
                    if (solve(list2)) return true;
                    list2.remove(list2.size() - 1);
                    if (num2 == 0) return false;
                    if (num2 != 0) {
                        list2.add(num1 / num2);
                        if (solve(list2)) return true;
                        list2.remove(list2.size() - 1);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {3, 3, 8, 8};
        System.out.println(new Game24Points().Game24Points(arr));
    }
}

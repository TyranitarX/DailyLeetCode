package MeiTuan;

import java.util.Scanner;

public class Course2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] first = in.nextLine().split(" ");
        String[] next = in.nextLine().split(" ");
        int nums = Integer.parseInt(first[0]);
        int k = Integer.parseInt(first[1]);
        int[] use = new int[nums];
        for (int i = 0; i < nums; i++) {
            use[i] = Integer.parseInt(next[i]);
        }
        int count = 0;
        for (int i = 0; i < use.length; i++) {
            for (int j = i + 1; j < use.length; j++) {
                if (use[i] + use[j] <= k)
                    count++;
            }
        }
        System.out.println(count);
    }
}

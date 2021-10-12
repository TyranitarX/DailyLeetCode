package MeiTuan;

import java.util.Arrays;
import java.util.Scanner;

public class Course3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] first = in.nextLine().split(" ");
        int friends = Integer.parseInt(first[0]);
        int goods = Integer.parseInt(first[1]);
        String[] second = in.nextLine().split(" ");
        String[] trird = in.nextLine().split(" ");
        String[] fourth = in.nextLine().split(" ");
        Integer[] counts = Arrays.stream(second).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] good = Arrays.stream(trird).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] friendmin = Arrays.stream(fourth).map(Integer::parseInt).toArray(Integer[]::new);
        Arrays.sort(good);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < friends; i++) {
            int count = 0;
            int nums = counts[i];
            int mingood = friendmin[i];
            for (int j = 0; j < good.length; j++) {
                if (good[j] >= mingood) {
                    nums--;
                    count += good[j];
                }
                if (nums == 0)
                    break;
            }
            if (nums != 0)
                sb.append("-1 ");
            else
                sb.append(count).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}

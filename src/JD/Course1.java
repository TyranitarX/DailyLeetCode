package JD;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 一片房区看做一个二维数组，小明觉得相邻的两户人家关系可能较好，小明把在一条对角线上的住户
 * 看做邻居。现在想要统计共有多少组住户是邻居。
 * <p>
 * 输入第一行为建筑树 2~n行为房子的xy坐标
 * 3
 * 2 3
 * 3 4
 * 1 4
 */
public class Course1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] people = new int[n][2];
        for (int i = 0; i < n; i++) {
            people[i][0] = in.nextInt();
            people[i][1] = in.nextInt();
        }
        Map<Integer, Integer> dp1 = new HashMap<>();
        Map<Integer, Integer> dp2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = people[i][0] + people[i][1];
            int b = people[i][0] - people[i][1];
            dp1.put(a, dp1.getOrDefault(a, 0) + 1);
            dp2.put(b, dp2.getOrDefault(b, 0) + 1);
        }
        int ans = 0;
        for (Integer v : dp1.values()) {
            ans += (v - 1) * v / 2;
        }
        for (Integer v : dp2.values()) {
            ans += (v - 1) * v / 2;
        }
        System.out.println(ans);
    }
}


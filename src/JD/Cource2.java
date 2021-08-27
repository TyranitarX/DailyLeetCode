package JD;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 输入一串字符串仅包含0和1 现在从头开始遍历 从0开始到当前位置的子串进行拆分后 多个字符串中0和1的数量比相同 即a：b=c：d
 * 输出最大能拆分出几部分。
 * 输入两行数据 第一行为字符串长度n
 * 第二行为字符串
 * 输出每个前缀的可划分的子串数
 * <p>
 * 如
 * 输入：
 * 3
 * 010100001
 * <p>
 * 输出
 * <p>
 * 1 1 1 2 1 2 1 1 3
 */
public class Cource2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String line = in.nextLine();
        String[] ss = line.split("");
        int one = 0;
        int zero = 0;
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = ss[i];
            if (s.equals("0")) {
                zero++;
            } else {
                one++;
            }
            double key = (one == 0 ? -1 : (zero * 1.0d) / one);
            map.put(key, map.getOrDefault(key, 0) + 1);
            System.out.print(map.get(key));
            System.out.print((i == n - 1) ? "" : " ");
        }
    }
}

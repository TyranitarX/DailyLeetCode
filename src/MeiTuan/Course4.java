package MeiTuan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Course4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int points = Integer.parseInt(in.nextLine());
        String[] value = in.nextLine().split(" ");
        int[] values = new int[points];
        for (int i = 0; i < value.length; i++) {
            values[i] = Integer.parseInt(value[i]);
        }
        String[] connect = in.nextLine().split(" ");
        Map<Integer, Integer> connects = new HashMap<>();
        for (int i = 0; i < connect.length; i++) {
            connects.put(Integer.parseInt(connect[i]), i);
        }
        int[] res = new int[points];
        for (int i = 0; i < points; i++) {
            for (int j = i; j < points; j++) {
                if (i == j)
                    res[i] = res[i] + 1;
                else {
                    int maxvalue = values[j];
                    int maxcur = j;
                    int cur = j;
                    while (connects.get(cur) != i) {
                        cur = connects.get(cur);
                        if (values[cur] > maxvalue) {
                            maxvalue = values[cur];
                            maxcur = cur;
                        }
                    }
                    if (values[i] > maxvalue) {
                        maxcur = i;
                    }
                    res[maxcur] = res[maxcur] + 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}

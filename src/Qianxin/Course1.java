package Qianxin;

import java.util.*;

public class Course1 {
    public int DoPermute(int M, int N) {
        int count;
        int cur = 0;
        List<Integer> monkeylist = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            monkeylist.add(i + 1);
        }
        while (true) {
            if (monkeylist.size() == 1)
                break;
            count = 0;
            while (count < M) {
                count++;
                cur = (cur + 1) % monkeylist.size();
            }
            cur = cur>0?cur - 1:monkeylist.size()-1;
            monkeylist.remove(cur);
            M++;
        }
        return monkeylist.get(0);
    }

    public static void main(String[] args) {
        System.out.println(new Course1().DoPermute(3, 5));
    }
}

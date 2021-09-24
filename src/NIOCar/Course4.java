package NIOCar;

import java.util.ArrayList;
import java.util.List;

public class Course4 {
    public int nomiJumps(int a, int b, int x, int[] trap) {
        int count = 0;
        List<Integer> traps = new ArrayList<>();
        for (int i = 0; i < trap.length; i++) {
            traps.add(trap[i]);
        }
        int i = 0;
        while (i != x) {
            if (i + a == x) {
                count++;
                break;
            }
            if (!traps.contains(i + a) && i + a < x) {
                i = i + a;
            } else {
                i = i - b;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Course4().nomiJumps(3, 6, 9, new int[]{1, 2}));
    }
}

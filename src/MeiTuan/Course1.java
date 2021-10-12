package MeiTuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Course1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] first = in.nextLine().split(" ");
        int order = Integer.parseInt(first[0]);
        int mei = Integer.parseInt(first[1]);
        int k = Integer.parseInt(first[2]);
        List<String[]> orderlist = new ArrayList<>();
        List<String[]> meilist = new ArrayList<>();
        for (int i = 0; i < order; i++) {
            orderlist.add(in.nextLine().split(" "));
        }
        for (int i = 0; i < mei; i++) {
            meilist.add(in.nextLine().split(" "));
        }
        int maxtime1 = Integer.parseInt(orderlist.get(order - 1)[1]);
        int maxtime2 = Integer.parseInt(meilist.get(mei - 1)[1]);
        int[] orderindex = new int[Math.max(maxtime1, maxtime2)];
        int[] meiintdex = new int[Math.max(maxtime1, maxtime2)];
        Arrays.fill(orderindex, -1);
        Arrays.fill(meiintdex, -1);
        for (int i = 0; i < order; i++) {
            String[] curorder = orderlist.get(i);
            int start = Integer.parseInt(curorder[0]);
            int end = Integer.parseInt(curorder[1]);
            int type = Integer.parseInt(curorder[2]);
            for (int j = start; j < end; j++) {
                orderindex[j] = type;
            }
        }
        for (int i = 0; i < mei; i++) {
            String[] curmei = meilist.get(i);
            int start = Integer.parseInt(curmei[0]);
            int end = Integer.parseInt(curmei[1]);
            int type = Integer.parseInt(curmei[2]);
            for (int j = start; j < end; j++) {
                meiintdex[j] = type;
            }
        }
        int count = 0;
        int curwrong = 0;
        int i = 0;
        while (i < orderindex.length) {
            while (i < orderindex.length && meiintdex[i] != -1 && meiintdex[i] != orderindex[i]) {
                curwrong++;
                i++;
            }
            if (curwrong != 0 && curwrong < k)
                count++;
            curwrong = 0;
            i++;
        }
        System.out.println(count);
    }
}

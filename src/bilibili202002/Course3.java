package bilibili202002;

import java.util.Scanner;

public class Course3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(" ");
        String pairs = strs[0];
        String kv = strs[1];
        String[] kvs = strs[2].split(pairs);
        System.out.println(kvs.length);
        for (int i = 0; i < kvs.length; i++) {
            String[] pairkv = kvs[i].split(kv);
            System.out.print(pairkv[0] + " ");
            System.out.println(pairkv[1]);
        }
    }
}

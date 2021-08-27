package bilibili2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Course1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<List<Integer>> arraylist = new ArrayList<>();
        while (in.hasNext()) {
            List<Integer> mylist = new ArrayList<>();
            String[] nums = in.nextLine().split(",");
            for (String num : nums) {
                mylist.add(Integer.parseInt(num));
            }
            arraylist.add(mylist);
        }
//        List<Integer> arraylist1 = new ArrayList<>();
//        arraylist1.add(1);
//        arraylist1.add(2);
//        arraylist1.add(3);
//        arraylist1.add(4);
//        arraylist1.add(5);
//        arraylist1.add(9);
//        List<Integer> arraylist2 = new ArrayList<>();
//        arraylist2.add(2);
//        arraylist2.add(4);
//        arraylist2.add(5);
//        arraylist2.add(6);
//        arraylist2.add(9);
//        arraylist2.add(10);
//        List<Integer> arraylist3 = new ArrayList<>();
//        arraylist3.add(3);
//        arraylist3.add(5);
//        arraylist3.add(6);
//        arraylist3.add(7);
//        arraylist3.add(9);
//        arraylist3.add(11);
//        List<Integer> arraylist4 = new ArrayList<>();
//        arraylist4.add(1);
//        arraylist4.add(3);
//        arraylist4.add(5);
//        arraylist4.add(7);
//        arraylist4.add(9);
//        arraylist.add(arraylist1);
//        arraylist.add(arraylist2);
//        arraylist.add(arraylist3);
//        arraylist.add(arraylist4);
        int maxpos = 0;
        int site = 0;
        for (int i = 0; i < arraylist.size(); i++) {
            if (arraylist.get(i).get(0) > maxpos) {
                site = i;
                maxpos = arraylist.get(i).get(0);
            }
        }
        List<Integer> maxlist = arraylist.get(site);
        int pos = -1;
        for (Integer integer : maxlist) {
            boolean judge = false;
            for (int j = 0; j < arraylist.size(); j++) {
                if (j != site) {
                    List<Integer> nowlist = arraylist.get(j);
                    if (!nowlist.contains(integer))
                        break;
                }
                if (j == arraylist.size() - 1) {
                    judge = true;
                    pos = integer;
                    break;
                }
            }
            if (judge)
                break;
        }
        System.out.println(pos);
    }
}

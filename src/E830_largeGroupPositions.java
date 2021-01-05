import java.util.ArrayList;
import java.util.List;

public class E830_largeGroupPositions {
    public List<List<Integer>> largeGroupPositions(String s) {
        if (s.length() == 0)
            return new ArrayList<>();
        List<List<Integer>> biglist = new ArrayList<>();
        int count = 1;
        int start = 0;
        int end = 0;
        char pre = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == pre) {
                count++;
                end = i;
            } else {
                if (count >= 3) {
                    List<Integer> thislist = new ArrayList<>();
                    thislist.add(start);
                    thislist.add(end);
                    biglist.add(thislist);
                }
                count = 1;
                start = i;
                end = i;
                pre = s.charAt(i);
            }
            if (i == s.length() - 1){
                if (count >= 3) {
                    List<Integer> thislist = new ArrayList<>();
                    thislist.add(start);
                    thislist.add(end);
                    biglist.add(thislist);
                }
            }
        }
        return biglist;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(new E830_largeGroupPositions().largeGroupPositions(s));
    }
}

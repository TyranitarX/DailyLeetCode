import java.util.ArrayList;
import java.util.LinkedList;
//
public class M3_lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        int k = 0;
        String[] ss = s.split("");
        int maxlength = 1;
        int pre = 0;
        for (; k < ss.length - 1; ) {
            int nowlength = 1;
            ArrayList<String> x = new ArrayList();
            x.add(ss[k]);
            for (int j = k + 1; j < ss.length; j++) {
                if (x.contains(ss[j])) {
                    k = x.indexOf(ss[j]) + pre + 1;
                    pre = k;
                    if (nowlength > maxlength)
                        maxlength = nowlength;
                    break;
                }
                if (j == ss.length - 1) {
                    k = ss.length;
                    nowlength++;
                    if (nowlength > maxlength)
                        maxlength = nowlength;
                    break;
                }
                nowlength++;
                x.add(ss[j]);
            }
        }
        return maxlength;
    }

    public static void main(String args[]) {
        String x = "aabcc";
        System.out.println(lengthOfLongestSubstring(x));
    }
}

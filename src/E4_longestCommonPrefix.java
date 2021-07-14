import java.util.Arrays;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/7/14 14:50
 **/
public class E4_longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int m = strs[0].length();
        int n = strs[strs.length - 1].length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < Math.min(m, n) && strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) {
            sb.append(strs[0].charAt(i));
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(new E4_longestCommonPrefix().longestCommonPrefix(strs));
    }
}

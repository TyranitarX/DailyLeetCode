/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/4/21 9:12
 **/
public class M91_numDecodings {

    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0')
            return 0;
        int n = s.length();
        int[] method = new int[n + 1];
        method[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                method[i] += method[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                method[i] += method[i - 2];
            }
        }
        return method[n];
    }
}

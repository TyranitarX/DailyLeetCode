package byteDance;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/25 16:26
 **/
public class M8_atoi {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0)
            return 0;
        int pre = 0;
        boolean neg = false;
        int i = 0;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            i = 1;
            neg = str.charAt(0) == '-';
        }
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                if (pre > ((Integer.MAX_VALUE - (c - '0')) / 10)) {
                    return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                pre = pre * 10 + (c - '0');
            } else
                break;
        }
        pre = neg ? -pre : pre;
        return pre;
    }

    public static void main(String[] args) {
        String str = "2147483648";
        System.out.println(new M8_atoi().myAtoi(str));
    }
}

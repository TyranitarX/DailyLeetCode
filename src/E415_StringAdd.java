public class E415_StringAdd {
    public static String addStrings(String num1, String num2) {
        StringBuffer s = new StringBuffer();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i < 0 ? 0 : num1.charAt(i--) - '0';
            int y = j < 0 ? 0 : num2.charAt(j--) - '0';
            int sum = x + y + carry;
            s.append(sum % 10);
            carry = sum / 10;
        }
        return s.reverse().toString();
    }

    public static void main(String args[]) {
        System.out.println(E415_StringAdd.addStrings("1237", "123"));
        System.out.println("1234".charAt(0)-'0'+"12345".charAt(0)-'0');
    }

}

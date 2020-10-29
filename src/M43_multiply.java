public class M43_multiply {
    public String multiply(String num1, String num2) {
        StringBuffer s = new StringBuffer();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i < 0 ? 0 : num1.charAt(i--) - '0';
            int y = j < 0 ? 0 : num2.charAt(j--) - '0';
            int sum = x * y + carry;
            s.append(sum % 10);
            carry = sum / 10;
        }
        return s.reverse().toString();
    }

    public static void main(String args[]) {
        System.out.println(new M43_multiply().multiply("123", "456"));
    }
}

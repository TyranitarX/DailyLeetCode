package PerfectWorld;

public class Course3 {
    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0)
            return "";
        boolean sign = true;
        if (num1.charAt(0) == '-') {
            num1 = num1.substring(1);
            sign = false;
        }
        if (num2.charAt(0) == '-') {
            num2 = num2.substring(1);
            sign = !sign;
        }
        long total = 0;
        int outtens = 1;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int tens = 1;
            for (int j = num2.length() - 1; j >= 0; j--) {
                if(num2.charAt(j)=='-'||num1.charAt(i)=='-')
                    return "";
                long now1 = num2.charAt(j) - '0';
                long now2 = num1.charAt(i) - '0';
                total += now1 * now2 * tens * outtens;
                tens = tens * 10;
            }
            outtens = outtens * 10;
        }
        return sign ? String.valueOf(total) : String.valueOf(-total);
    }

    public static void main(String[] args) {
        System.out.println(new Course3().multiply("001", "-3"));
    }
}

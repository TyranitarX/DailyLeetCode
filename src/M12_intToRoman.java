public class M12_intToRoman {
    public String intToRoman(int num) {
        String[] romans = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            for (int i = romans.length - 1; i >= 0; i--) {
                int value = values[i];
                String roman = romans[i];
                while (num >= value) {
                    num -= value;
                    sb.append(roman);
                }
                if (num == 0)
                    break;
            }
        }
        return sb.toString();
    }
}

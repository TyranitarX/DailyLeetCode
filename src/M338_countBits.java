
public class M338_countBits {
    /**
     * trash solve
     *
     * @param args
     */
   /* public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            result[i] = countone(i);
            System.out.println(result[i]);
        }
        return result;
    }

    public int countone(int num) {
        String binarynum = Integer.toBinaryString(num);
        int len = binarynum.length();
        int total = 0;
        int key = 2;
        for (int i = 1; i <= len; i++) {
            if ((num + 1) % key == 0)
                total += 1;
            else if ((num + 1) % key > (key / 2))
                total += 1;
            key = key * 2;
        }
        return total;
    }*/

    /**
     * DP最高有效位
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        int highBit = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

    public static void main(String[] args) {
        new M338_countBits().countBits(8);
    }
}

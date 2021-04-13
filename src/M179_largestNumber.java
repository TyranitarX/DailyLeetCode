import java.util.Arrays;
import java.util.concurrent.ThreadPoolExecutor;


public class M179_largestNumber {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        int n = nums.length;
        Integer[] numss = new Integer[n];
        for (int i = 0; i < n; i++) {
            numss[i] = nums[i];
        }
        Arrays.sort(numss, (num1, num2) -> {
            String[] num01 = String.valueOf(num1).split("");
            String[] num02 = String.valueOf(num2).split("");
            int i = 0;
            while (i < num01.length - 1 && i < num02.length - 1 && Integer.parseInt(num02[i]) - Integer.parseInt(num01[i]) == 0)
                i++;
            if (i < num01.length - 1 && Integer.parseInt(num01[i + 1]) > Integer.parseInt(num02[0]))
                return -1;
            else if (i < num01.length - 1 && Integer.parseInt(num01[i + 1]) <= Integer.parseInt(num02[0]))
                return 1;
            if (i < num02.length - 1 && Integer.parseInt(num02[i + 1]) > Integer.parseInt(num01[0]))
                return 1;
            else if (i < num02.length - 1 && Integer.parseInt(num02[i + 1]) <= Integer.parseInt(num01[0]))
                return -1;
            return Integer.parseInt(num02[i]) - Integer.parseInt(num01[i]);
        });
        for (int i = 0; i < n; i++) {
            sb.append(numss[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {34323,3432};
        System.out.println(new M179_largestNumber().largestNumber(nums));
    }
}

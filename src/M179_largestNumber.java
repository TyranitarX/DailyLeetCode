import java.util.Arrays;
import java.util.concurrent.ThreadPoolExecutor;


public class M179_largestNumber {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        Integer[] numss = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numss, (num1, num2) -> {
            String as = String.valueOf(num1);
            String bs = String.valueOf(num2);
            return (bs + as).compareTo(as + bs);
        });
        if (numss[0].equals(0)) return "0";
        for (int i = 0; i < nums.length; i++) {
            sb.append(numss[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {0, 0};
        System.out.println(new M179_largestNumber().largestNumber(nums));
    }
}

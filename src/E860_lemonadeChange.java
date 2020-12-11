public class E860_lemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int[] nums = new int[3];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                nums[0] += 1;
            } else if (bills[i] == 10) {
                if (nums[0] == 0)
                    return false;
                else {
                    nums[0] -= 1;
                    nums[1] += 1;
                }
            } else {
                if (nums[1] > 0 && nums[0] > 0) {
                    nums[0] -= 1;
                    nums[1] -= 1;
                    nums[2] += 1;
                } else if (nums[0] >= 3) {
                    nums[0] -= 3;
                    nums[2] += 1;
                } else
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5,5,10,10,20};
        System.out.println(new E860_lemonadeChange().lemonadeChange(bills));
    }
}

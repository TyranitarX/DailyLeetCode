public class M134_canCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int totalgas = 0;
            int j = i;
            while (true) {
                totalgas += gas[j];
                if (totalgas >= cost[j])
                    totalgas = totalgas - cost[j];
                else
                    break;
                j = j + 1 >= gas.length ? 0 : j + 1;
                if (j == i)
                    return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};
        System.out.println(new M134_canCompleteCircuit().canCompleteCircuit(gas, cost));
    }
}

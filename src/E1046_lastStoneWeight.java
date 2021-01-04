import java.util.Arrays;

public class E1046_lastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        while (stones.length > 1 && stones[stones.length - 2] != 0) {
            int rest = stones[stones.length - 1] - stones[stones.length - 2];
            if (rest == 0) {
                stones[stones.length - 1] = stones[stones.length - 2] = 0;
            } else {
                stones[stones.length - 2] = stones[stones.length - 1] - stones[stones.length - 2];
                stones[stones.length - 1] = 0;
            }
            Arrays.sort(stones);
        }
        return stones[stones.length - 1];
    }

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(new E1046_lastStoneWeight().lastStoneWeight(stones));
    }
}

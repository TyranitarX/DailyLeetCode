package bilibili202102;


public class GetMaxConsecutiveOnes {
    int max = 0;

    public int getMaxConsecutiveOnes(int[] arr, int k) {
        dfs(arr, 0, 0, k);
        return max;
    }

    public void dfs(int[] arr, int i, int count, int k) {
        if (count == k || i >= arr.length) {
            max = Math.max(countone(arr), max);
            return;
        }
        if (arr[i] == 0) {
            arr[i] = 1;
            dfs(arr, i + 1, count + 1, k);
            arr[i] = 0;
        }
        dfs(arr, i + 1, count, k);
    }

    public int countone(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int now = 0;
            while (i < arr.length && arr[i] == 1) {
                now++;
                i++;
            }
            count = Math.max(count, now);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(new GetMaxConsecutiveOnes().getMaxConsecutiveOnes(arr, 2));
    }
}

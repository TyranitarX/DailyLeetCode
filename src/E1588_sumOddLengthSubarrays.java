import java.util.ArrayList;
import java.util.List;

public class E1588_sumOddLengthSubarrays {
    int total = 0;

    public int sumOddLengthSubarrays(int[] arr) {
        dfs(arr, 0, new ArrayList<>(), false);
        return total;
    }

    public void dfs(int[] arr, int i, List<Integer> mylist, boolean pre) {
        if (i >= arr.length) {
            if (mylist.size() % 2 == 1)
                total += mylist.stream().reduce(Integer::sum).orElse(0);
            return;
        }
        if (mylist.size() == 0 || pre) {
            mylist.add(arr[i]);
            dfs(arr, i + 1, mylist, true);
            mylist.remove(mylist.size() - 1);
        }
        dfs(arr, i + 1, mylist, false);
    }

    public int sumOddLengthSubarrays2(int[] arr) {
        int total = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int now = 0;
            for (int j = i; j < n; j++) {
                now += arr[j];
                if ((j - i) % 2 == 0)
                    total += now;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 3, 3, 5};
        System.out.println(new E1588_sumOddLengthSubarrays().sumOddLengthSubarrays2(arr));
    }

}

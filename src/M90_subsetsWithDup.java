import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M90_subsetsWithDup {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> t = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return res;
    }

    public void dfs(Boolean pre, int now, int[] nums) {
        if (now == nums.length) {
            res.add(new ArrayList<>(t));
            return;
        }
        dfs(false, now + 1, nums);
        if (!pre && now > 0 && nums[now] == nums[now - 1])
            return;
        t.add(nums[now]);
        dfs(true, now + 1, nums);
        t.remove(t.size() - 1);
    }
}

import java.util.ArrayList;
import java.util.List;

public class M842_splitIntoFibonacci {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<Integer>();
        backtrack(list, S, S.length(), 0, 0, 0);
        return list;
    }

    public boolean backtrack(List<Integer> list, String s, int length, int index, int sum, int pre) {
        if (index == length)
            return list.size() > 2;
        long count = 0;
        for (int i = index; i < length; i++) {
            if (i > index && s.charAt(index) == '0')
                break;
            count = count * 10 + (s.charAt(i) - '0');
            if (count > Integer.MAX_VALUE)
                break;
            int curr = (int) count;
            if (list.size() >= 2) {
                if (curr < sum)
                    continue;
                else if (curr > sum)
                    break;
            }
            list.add(curr);
            if (backtrack(list, s, length, i + 1, pre + curr, curr)) {
                return true;
            } else {
                list.remove(list.size() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String S = "123456579";
        System.out.println(new M842_splitIntoFibonacci().splitIntoFibonacci(S));
    }
}

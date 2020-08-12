import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

public class H336_palindromePairs {
    //暴力（超时）
    public List<List<Integer>> palindromePairsForce(String[] words) {
        List<List<Integer>> returnList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                List<Integer> list = new ArrayList<>();
                String add = words[i] + words[j];
                if (isPalindrome(add) && i != j) {
                    list.add(i);
                    list.add(j);
                    returnList.add(list);
                }
            }
        }
        return returnList;
    }

    public boolean isPalindrome(String s) {
        if (s.equals(""))
            return true;
        String[] ss = s.split("");
        boolean judge = true;

        for (int i = 0; i < (s.length() / 2); i++) {
            if (!ss[i].equals(ss[ss.length - i - 1]))
                judge = false;
        }
        return judge;
    }

    //哈希表查找
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> reversemap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            reversemap.put(new StringBuilder(words[i]).reverse().toString(), i);
        }
        Set<List<Integer>> nodelist = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                String left = word.substring(j);
                String right = word.substring(0, j);
                if (isPalindrome(left)) {
                    List<Integer> list = new ArrayList<>();
                    if (reversemap.containsKey(right) && i != reversemap.get(right)) {
                        list.add(i);
                        list.add(reversemap.get(right));
                        nodelist.add(list);
                    }
                }
                if (isPalindrome(right)) {
                    if (reversemap.containsKey(left) && i != reversemap.get(left)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(reversemap.get(left));
                        list.add(i);
                        nodelist.add(list);
                    }
                }

            }
        }
        return new ArrayList<>(nodelist);
    }

    public static void main(String args[]) {
        String[] words = {"abcd", "dcba","lls","s","sssll"};
        System.out.println(new H336_palindromePairs().palindromePairs(words));

    }
}

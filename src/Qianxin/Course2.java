package Qianxin;

import java.util.*;

public class Course2 {
    StringBuilder cursb = new StringBuilder();
    Set<String> res = new HashSet<>();

    public String[] Permutation(char[] seed, int size) {
        for (int i = 0; i < seed.length; i++) {
            List<Character> seeds = new ArrayList<>();
            cursb = new StringBuilder();
            cursb.append(seed[i]);
            for (int j = 0; j < seed.length; j++) {
                if (j != i) {
                    seeds.add(seed[j]);
                }
            }
            dfs(seeds, size);
        }
        String[] ress = new String[res.size()];
        int i = 0;
        for (String re : res) {
            ress[i] = re;
            i++;
        }
        Arrays.sort(ress);
        return ress;
    }

    public void dfs(List<Character> seed, int size) {
        if (cursb.length() == size) {
            res.add(cursb.toString());
            return;
        }
        for (int j = 0; j < seed.size(); j++) {
            cursb.append(seed.get(j));
            List<Character> nexeseed = new ArrayList<>();
            for (int i = 0; i < seed.size(); i++) {
                if (i != j) {
                    nexeseed.add(seed.get(i));
                }
            }
            dfs(nexeseed, size);
            cursb.deleteCharAt(cursb.length() - 1);
        }

    }

    public static void main(String[] args) {
        char[] chars = {'0', '1', '2'};
        System.out.println(new Course2().Permutation(chars, 2));
    }
}

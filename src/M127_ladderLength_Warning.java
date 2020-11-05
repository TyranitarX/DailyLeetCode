import java.util.*;

public class M127_ladderLength_Warning {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> totalSet = new HashSet<>(wordList);
        if (!totalSet.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visit = new HashSet<>();
        visit.add(beginWord);

        int step = 1;
        while (!queue.isEmpty()) {
            int current = queue.size();
            for (int i = 0; i < current; i++) {
                String currentWord = queue.poll();
                char[] currentChar = currentWord.toCharArray();
                for (int j = 0; j < currentChar.length; j++) {
                    char orichar = currentChar[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == orichar)
                            continue;
                        currentChar[j] = k;
                        String nowWord = String.valueOf(currentChar);
                        if (totalSet.contains(nowWord)) {
                            if (nowWord.equals(endWord))
                                return step + 1;
                            if (!visit.contains(nowWord)) {
                                queue.offer(nowWord);
                                visit.add(nowWord);
                            }
                        }
                    }
                    currentChar[j] = orichar;
                }
            }
            step++;
        }
        return 0;
    }
    public static void main(String[] args){
        String beginword = "hit";
        String endword = "cog";
        List<String> list =new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(new M127_ladderLength_Warning().ladderLength(beginword,endword,list));
    }
}

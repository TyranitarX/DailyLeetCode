import java.util.*;

public class H127_ladderLength {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        boolean[] visit = new boolean[wordList.size()];
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        if (wordList.contains(beginWord))
            visit[wordList.indexOf(beginWord)] = true;
        int count = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            ++count;
            for (int p = 0; p < size; p++) {
                String start = queue.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    if (visit[i]) {
                        continue;
                    }
                    String s = wordList.get(i);
                    if (!canconvert(start, s)) {
                        continue;
                    }
                    if (s.equals(endWord)) {
                        return count + 1;
                    }
                    visit[i] = true;
                    queue.offer(s);
                }
            }
        }
        return 0;
    }

    public boolean canconvert(String a, String b) {
        if (a.length() != b.length()) return false;
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                count++;
        }
        return count == 1;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        List<String> arr = new ArrayList<>();
        arr.add("hot");
        arr.add("dot");
        arr.add("dog");
        arr.add("lot");
        arr.add("log");
        arr.add("cog");
        System.out.println(new H127_ladderLength().ladderLength(begin, end, arr));
    }
}

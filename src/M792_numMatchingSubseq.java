import java.util.ArrayList;
import java.util.List;

/**
 *  给定字符串 S 和单词字典 words, 求 words[i] 中是 S 的子序列的单词个数。
 *
 * 示例:
 * 输入:
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * 输出: 3
 * 解释: 有三个是 S 的子序列的单词: "a", "acd", "ace"。
 *
 *
 * 子序列 利用字典树解决 定义26字母开头的字典树
 */
public class M792_numMatchingSubseq {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        List<MyNode>[] nodes = new ArrayList[26];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < words.length; i++) {
            nodes[words[i].charAt(0) - 'a'].add(new MyNode(words[i], 0));
        }
        for (char c : s.toCharArray()) {
            List<MyNode> now = nodes[c - 'a'];
            nodes[c - 'a'] = new ArrayList<>();
            for (MyNode node : now) {
                node.index++;
                if (node.index == node.s.length()) {
                    count++;
                } else {
                    nodes[node.s.charAt(node.index) - 'a'].add(node);
                }
            }
            now.clear();
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a", "bb", "ace", "acd"};
        System.out.println(new M792_numMatchingSubseq().numMatchingSubseq(s, words));
    }
}

class MyNode {
    String s;
    int index;

    public MyNode(String s, int index) {
        this.s = s;
        this.index = index;
    }
}

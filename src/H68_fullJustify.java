import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/9 9:07
 **/
public class H68_fullJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        int nowlen = 0;
        List<String> res = new ArrayList<>();
        List<String> nowlist = new ArrayList<>();
        int i = 0;
        while (i <= n) {
            if (i == n) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < nowlist.size(); j++) {
                    sb.append(nowlist.get(j));
                    if(sb.length()<maxWidth)
                        sb.append(" ");
                }
                for (int j = 0; j < maxWidth - nowlen-nowlist.size(); j++) {
                    sb.append(" ");
                }
                res.add(sb.toString());
                break;
            }
            String now = words[i];
            if (nowlen + now.length() + nowlist.size() <= maxWidth) {
                nowlen += (now.length());
                nowlist.add(now);
                i++;
            } else {
                int wordss = nowlist.size();
                StringBuilder sb = new StringBuilder();
                if (wordss == 1) {
                    sb.append(nowlist.get(0));
                    for (int j = 0; j < maxWidth - nowlen; j++)
                        sb.append(" ");
                    res.add(sb.toString());
                    nowlen = 0;
                    nowlist = new ArrayList<>();
                    continue;
                }
                int spaces = maxWidth - nowlen;
                int spaceper = spaces / (wordss - 1);
                int rest = spaces % (wordss - 1);
                for (int j = 0; j < nowlist.size(); j++) {
                    sb.append(nowlist.get(j));
                    if (j != nowlist.size() - 1) {
                        for (int k = 0; k < spaceper; k++) {
                            sb.append(" ");
                        }
                        if (rest != 0) {
                            sb.append(" ");
                            rest--;
                        }
                    }
                }
                res.add(sb.toString());
                nowlen = 0;
                nowlist = new ArrayList<>();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        System.out.println(new H68_fullJustify().fullJustify(words, 20));
    }
}

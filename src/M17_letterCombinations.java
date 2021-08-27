import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M17_letterCombinations {
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return res;
        Map<Character, Character[]> digitmap = new HashMap<>();
        digitmap.put('2', new Character[]{'a', 'b', 'c'});
        digitmap.put('3', new Character[]{'d', 'e', 'f'});
        digitmap.put('4', new Character[]{'g', 'h', 'i'});
        digitmap.put('5', new Character[]{'j', 'k', 'l'});
        digitmap.put('6', new Character[]{'m', 'n', 'o'});
        digitmap.put('7', new Character[]{'p', 'q', 'r', 's'});
        digitmap.put('8', new Character[]{'t', 'u', 'v'});
        digitmap.put('9', new Character[]{'w', 'x', 'y', 'z'});
        getcombine(new StringBuilder(), digitmap, digits, 0);
        return res;
    }

    public void getcombine(StringBuilder sb, Map<Character, Character[]> digitmap, String digits, int key) {
        if (key == digits.length()) {
            res.add(sb.toString());
            return;
        }
        Character[] chars = digitmap.get(digits.charAt(key));
        for (Character aChar : chars) {
            sb.append(aChar);
            getcombine(sb, digitmap, digits, key + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

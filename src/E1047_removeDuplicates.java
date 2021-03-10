import java.util.Stack;

public class E1047_removeDuplicates {
    public String removeDuplicates(String s) {
        int n = s.length();
        StringBuffer sb = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        for (int i = 1; i < n; i++) {
            if (!stack.empty() && stack.peek().equals(s.charAt(i))) {
                stack.pop();
            } else
                stack.push(s.charAt(i));
        }
        for (char c : stack){
           sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new E1047_removeDuplicates().removeDuplicates("abbaca"));
    }
}

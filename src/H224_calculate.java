import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class H224_calculate {
    public int calculate(String s) {
        List<String> back = calculateBack(s);
        Stack<Integer> res = new Stack<>();
        int n = back.size();
        for (int i = 0; i < n; i++) {
            String c = back.get(i);
            if (c.length() > 1 || Character.isDigit(c.charAt(0)))
                res.push(Integer.parseInt(c));
            if (issymbol(c.charAt(0))) {
                int a = res.pop();
                int b = res.pop();
                switch (c.charAt(0)) {
                    case '+':
                        res.push(a + b);
                        break;
                    case '-':
                        res.push(b - a);
                        break;
                    case '*':
                        res.push(a * b);
                        break;
                    case '/':
                        res.push(b / a);
                        break;
                }
            }
        }
        return res.peek(); 
    }

    public List<String> calculateBack(String s) {
        int n = s.length();
        boolean pre = true;
        Stack<Character> symbol = new Stack<>();
        ArrayList<String> back = new ArrayList<>();
        back.add("0");
        StringBuilder duo = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                duo.append(c);
                if (pre)
                    back.remove(back.size() - 1);
                back.add(duo.toString());
                pre = true;
            } else {
                duo = new StringBuilder();
                pre = false;
                if (c == '(')
                    symbol.push(c);
                if (c == ')') {
                    while (symbol.peek() != '(')
                        back.add(symbol.pop() + "");
                    symbol.pop();
                }
                if (issymbol(c)) {
                    while (!symbol.empty() && issymbol(symbol.peek()) && (judgeOut(c) - judgeOut(symbol.peek())) >= 0) {
                        back.add(symbol.pop() + "");
                    }
                    symbol.push(c);
                }
            }
        }
        while (!symbol.empty()) {
            back.add(symbol.pop() + "");
        }
        return back;
    }

    public int judgeOut(char c) {
        return c == '+' || c == '-' ? 1 : 0;
    }

    public boolean issymbol(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static void main(String[] args) {
        String s = "-2+1";
        System.out.println(new H224_calculate().calculate(s));
    }

}
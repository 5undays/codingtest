package interview;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MathExpression {

    public static void main(String[] args) {
        MathExpression mathExpression = new MathExpression();
        boolean chk = mathExpression.check("[{(mathExpression)}");
        System.out.println(chk);
    }

    // 괄호 짝 체크 문제
    private boolean check(String mathExpression) {
        Stack<Character> brackets = new Stack<>();
        char[] chars = mathExpression.toCharArray();
        List<Character> openingBrackets = Arrays.asList('(', '{', '[');
        List<Character> closingBrackets = Arrays.asList(')', '}', ']');

        for (char c : chars) {
            if (openingBrackets.contains(c)) {
                brackets.push(c);
            } else if (closingBrackets.contains(c)) {
                if (brackets.isEmpty()) {
                    return false;
                } else {
                    Character openingBracket = brackets.pop();
                    if (closingBrackets.indexOf(c) != openingBrackets.indexOf(openingBracket)) {
                        return false;
                    }
                }
            }
        }

        return brackets.isEmpty();
    }
}

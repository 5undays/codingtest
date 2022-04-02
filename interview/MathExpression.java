package interview;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MathExpression {

    List<Character> openingBrackets = Arrays.asList('(', '{', '[');
    List<Character> closingBrackets = Arrays.asList(')', '}', ']');

    public static void main(String[] args) {
        MathExpression mathExpression = new MathExpression();
        boolean chk = mathExpression.check("[{(mathExpression)}");
        System.out.println(chk);
        
        int idx = mathExpression.matchIndex("[{1+2*(2+2)}-(1-3)]", 0);
        System.out.println(idx);
    }

    // 괄호 짝 체크 문제
    private boolean check(String mathExpression) {
        Stack<Character> brackets = new Stack<>();
        char[] chars = mathExpression.toCharArray();

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

    class NodeTest {
        Character bracket;
        int index;  
    }
    /**
     * matchIdx 에 대응하는 괄호 위치 찾기
     * 
     * @param expression 괄호 수식
     * @param matchIdx   여는 괄호
     * @return 닫는 괄호 위치
     */
    private int matchIndex(String expression, int matchIdx) {
        Stack<NodeTest> brackets = new Stack<>();
        char close = closingBrackets.get(matchIdx);
        char[] exp = expression.toCharArray();
        
        for (int i = 0; i < exp.length; i++) {
            if (openingBrackets.contains(exp[i])) {
                NodeTest nodeTest = new NodeTest();
                nodeTest.index = i;
                nodeTest.bracket = exp[i];
                brackets.push(nodeTest);
            } else if (closingBrackets.contains(exp[i])) {
                NodeTest openingBracket = brackets.pop();
                if (closingBrackets.indexOf(exp[i]) != openingBrackets.indexOf(openingBracket)) {
                    return openingBracket.index;
                }
            }
        }
        return 0;
    }
}

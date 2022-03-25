package interview;

import java.util.*;

public class StackExample {

    public static void main(String[] args) {
        StackExample example = new StackExample();
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        s = example.solution(s);
        System.out.println(s.toString());
    }

    // 스택을 뒤집기 (반복)
    private Stack<Integer> solution(Stack<Integer> stack) {
        Stack<Integer> result = new Stack<>();
        while (!stack.isEmpty()) {
            result.push(stack.pop());
        }
        return result;
    }

    // 스택 뒤집기 (재귀)
    private void solutionRecursive(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int temp = stack.pop();
        solutionRecursive(stack);
        insertAtBottom(stack, temp);
    }

    private void insertAtBottom(Stack<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }
        int temp = stack.pop();
        insertAtBottom(stack, value);
        stack.push(temp);
    }

    // 배열에서 인덱스의 값보다 큰 배열의 갯수을 반환
    private int[] currentOverNumber(int[] prices) {
        int[] span = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        span[0] = 1;

        for (int i = 1; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        return span;
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
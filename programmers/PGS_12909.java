package programmers;

import java.util.Stack;

/**
 * 올바른 괄호
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */
public class PGS_12909 {
    public static void main(String[] args) {
        PGS_12909 pgs_12909 = new PGS_12909();
//        System.out.println(pgs_12909.solution("()()"));
        System.out.println(pgs_12909.solution("(()("));
    }

    boolean solution(String k) {
        boolean answer = true;
        Stack<Character> s = new Stack<>();
        for (int i = 0 ; i < k.length(); i++) {
            if (k.charAt(i) == '(') { // 여는 괄호
                s.push('(');
            } else { // 닫는 괄호
                if (s.isEmpty() || s.peek() != '(') {
                    return false;
                } else {
                    s.pop();
                }
            }
        }

        if (!s.isEmpty()) {
            answer = false;
        }
        return answer;
    }
}

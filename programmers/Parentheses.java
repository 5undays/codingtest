package programmers;

import java.util.Stack;

// https://programmers.co.kr/learn/courses/30/lessons/43105
public class Parentheses {

    public static void main(String[] args) {
        Parentheses parentheses = new Parentheses();
        int answer1 = parentheses.solution(2);
        int answer2 = parentheses.solution(3);
        System.out.println(answer1);
        System.out.println(answer2);
    }

    private int solution(int n) {
        int answer = 0;
        Stack<String> s = new Stack<>();
        for (int i = 0; i < n; i++) {

        }
        return answer;
    }
}

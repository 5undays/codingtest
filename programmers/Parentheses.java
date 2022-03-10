package programmers;

import java.util.Stack;

// 올바른 괄호
// https://programmers.co.kr/learn/courses/30/lessons/12909
public class Parentheses {

    public static void main(String[] args) {
        Parentheses parentheses = new Parentheses();
        int answer1 = parentheses.solution(2);
        int answer2 = parentheses.solution(3);
        System.out.println(answer1);
        System.out.println(answer2);
    }

    class P {
        int open, close;
        P(int open, int close) {
            this.open = open;
            this.close = close;
        }
    }

    private int solution(int n) {
        int answer = 0;
        Stack<P> s = new Stack<>();
        s.push(new P(0,0));
        while (!s.isEmpty()) {
            P p = s.pop();
            if (p.open > n) continue;
            if (p.open < p.close) continue;
            if (p.open + p.close == 2*n) {
                answer++;
                continue;
            }
            s.push(new P (p.open+1, p.close));
            s.push(new P (p.open, p.close+1));
        }
        return answer;
    }
}

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

    private int solution() {
        boolean answer = false;
        
        Stack<Character> a = new Stack<Character>();
        
        for(int i=0; i<s.length(); i++) {            
            if(s.charAt(i)=='(') {
                a.push(s.charAt(i));
            }
            //answer를 false로 초기화 해놓고 바로 return을 해줘야 시간초과가 나지 않는다.
            else {
                if(a.isEmpty()) {
                    return answer;
                } else if(a.pop()!='(') {
                    return answer;
                }
            }
        }
        
        if(a.isEmpty()) {
            answer = true;
        }
 
        return answer;
    }
}

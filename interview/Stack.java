package interview;

public class Stack {

    public static void main(String[] args) {

    }
    
    // 스택을 뒤집기
    private Stack<Integer> solution(Stack<Integer> stack) {
        Stack<Integer> result = new Stack<>();
        while (stack.isEmpty()) {
            result.push(stack);
        }
        return result;
    }
}
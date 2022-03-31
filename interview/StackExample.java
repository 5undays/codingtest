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
        // System.out.println(s.toString());

        StackForQueue stackForQueue = new StackForQueue();
        stackForQueue.offer(1);
        stackForQueue.offer(2);
        stackForQueue.offer(3);
        stackForQueue.offer(4);
        while (!stackForQueue.stack2.isEmpty()) {
            System.out.println(stackForQueue.poll());
        }
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

    // 스택으로 큐를 구현하기
    public static class StackForQueue {

        Stack<Integer> stack = new Stack<>(); // 역방향으로 옮겨질 것임
        Stack<Integer> stack2 = new Stack<>(); // 정방향으로 넣어질 것임

        private void offer(int number) {
            stack.push(number);
            Stack<Integer> stack3 = stack;
            stack2.clear();
            for (int i = stack3.size() - 1; i >= 0; i--) {
                stack2.push(stack.get(i));
            }
        }

        private Integer poll() {
            if (stack2.isEmpty()) {
                return null;
            }
            return stack2.pop();
        }
    }

}
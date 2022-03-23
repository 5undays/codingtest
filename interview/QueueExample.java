package interview;

import java.util.Queue;
import java.util.Stack;

public class QueueExample {

    public static void main(String[] args) {

    }

    // 큐 역방향
    private Queue<Integer> reverse(Queue<Integer> numbers) {
        Stack<Integer> stack = new Stack<>();
        while (!numbers.isEmpty()) {
            stack.push(numbers.poll());
        }
        while (!stack.isEmpty()) {
            numbers.add(stack.pop());
        }
        return numbers;
    }

    // 큐 역방향
    private Queue<Integer> reverse2(Queue<Integer> numbers) {
        if (!numbers.isEmpty()) {
            return numbers;
        }

        int front = numbers.poll();
        numbers = reverse(numbers);
        numbers.offer(front);
        return numbers;
    }


}

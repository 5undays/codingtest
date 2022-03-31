package interview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueExample {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        QueueExample example = new QueueExample();
        queue = example.reverse(queue);
        System.out.println(queue.toString());

        QueueForStack stack = new QueueForStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while(!stack.queue.isEmpty()) {
            System.out.println(stack.pop());
        }
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

    // 큐로 스택을 구현하기
    public static class QueueForStack {

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        private void push(int number) {
            queue2.offer(number);

            while (!queue.isEmpty()) {
                queue2.offer(queue.poll());
            }

            Queue<Integer> temp = queue;
            queue = queue2;
            queue2 = temp;
        }

        private Integer pop() {
            if (queue.isEmpty()) {
                return null;
            }
            return queue.poll();
        }

        private Integer pop2() {
            if (queue.isEmpty()) {
                return null;
            }

            while (queue.size() > 1) {
                queue2.offer(queue.poll());
            }

            Integer value = queue.poll();

            Queue<Integer> temp = queue;
            queue = queue2;
            queue2 = temp;

            return value;
        }

        private void push2(int number) {
            queue.offer(number);
        }
    }

}

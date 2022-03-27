package interview;

import java.util.*;

public class LinkedListExample {
    Node head;
    Node tail;

    static class Node {
        private Node next;
        private int value;

        Node() {

        }
    }

    public static void main(String[] args) {
        Node node = new Node();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        node.value = 1;
        node1.value = 2;
        node2.value = 2;
        node3.value = 4;
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        test(node);
        removeDuplicatesIterator(node);
    }

    private static void test(Node node) {
        Node current = node;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    private static void removeDuplicatesIterator(Node node) {
        Node current = node;
        while (current != null) {
            Node temp = current;
            // 중복 제거
            while (temp != null && temp.value == current.value) {
                temp = temp.next;
            }

            // 다음 노트 설정
            current.next = temp;
            System.out.println(current.value);
            current = current.next;
        }
    }

    private void removeDuplicatesIterator2() {
        Node current = this.head;
        Node prev = this.head;

        while (current != null) {
            if (current.value != prev.value) {
                prev.next = current;
                prev = current;
            }
            current = current.next;
        }

        if (prev != current) {
            prev.next = null;
        }
    }

    private Node removeDuplicatesRecursive(Node node) {
        if (node == null) {
            return null;
        }

        if (node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
                removeDuplicatesRecursive(node);
            } else {
                removeDuplicatesRecursive(node.next);
            }
        }
        return node;
    }

    // 중복 제거 (Map 사용)
    private void removeDuplicates() {
        Set<Integer> numberSet = new HashSet<>();

        Node current = this.head;
        Node prev = this.head;

        while (current != null) {
            int currentNumber = current.value;
            if (numberSet.contains(currentNumber)) {
                prev.next = current.next;
            } else {
                numberSet.add(currentNumber);
                prev = current;
            }
        }

        current = current.next;
    }

    // 리스트 뒤집기
    private void reverse() {
        Node current = this.head;
        Node prev = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        this.tail = this.head;
        this.head = prev;
    }

    // 리스트 뒤집기 (재귀)
    private void reverse2() {
        Node head = this.head;
        this.head = reverRecursive(head);
        this.tail = head;
    }

    private Node reverRecursive(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node reversedNode = reverRecursive(node.next);
        node.next.next = node;
        node.next = null;
        return reversedNode;
    }

    // POSTFIX 사칙 연산
    private int evaluate(String s) {
        LinkedList<Integer> numbers = new LinkedList<>();
        char[] chars = s.trim().toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) { // 숫자 이면

            } else { // 숫자가 아닌 연산기호
                int left = numbers.pop();
                int right = numbers.pop();
                switch (c) {
                    case '+':
                        numbers.push(left + right);
                        break;
                    case '-':
                        numbers.push(left - right);
                        break;
                    case '/':
                        numbers.push(left / right);
                        break;
                    case '*':
                        numbers.push(left * right);
                        break;
                }

            }
        }
        return numbers.pop();
    }
}
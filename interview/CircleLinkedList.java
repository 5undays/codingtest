package interview;

import java.util.*;

public class CircleLinkedList {
    private Node head;

    class Node {
        private Node head;
        private Node tail;
        private int value;
    }

    public static void main(String[] args) {

    }

    // 원형 연결 리스트 인지 검사 (반복)
    private boolean hasCircle() {
        Set<Node> nodeSet = new HashSet<>();
        Node current = this.head;
        while (current != null) {
            if (nodeSet.contains(current.value)) {
                return true;
            } else {
                nodeSet.add(current);
            }
            current = current.tail;
        }
        return false;
    }

    // 원형 연결 리스트 인지 검사 (포인터 두개 사용)
    private boolean hasCircle2() {
        Node slow = new Node();
        Node fast = new Node();

        while (fast != null) {
           if (fast.tail == null || fast.tail.tail == null) {
               return false;
           }

           fast = fast.tail.tail;
           if (slow.value == fast.value) {
               return true;
           }

           slow = fast.tail;
        }

        return false;
    }

    // TODO
    private Node startCircle() {
        Node node = new Node();
        return node;
    }
}
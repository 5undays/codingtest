package interview;

import java.util.*;

public class CircleLinkedList {
    
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
                nodeSet.add(current.value);
            }
            current = current.next;
        }
        return false;
    }

    // 원형 연결 리스트 인지 검사 (포인터 두개 사용)
    private boolean hasCircle2() {
        Node slow = new Node();
        Node fast = new Node();

        while (fast != null) {
           if (fast.next == null || fast.next.next == null) {
               return false;
           }

           fast = fast.next.next;
           if (slow.value == fast.value) {
               return true;
           }

           slow = fast.next;
        }

        return false;
    }

    // TODO
    private Node startCircle() {
        Node node = new Node();
        return node;
    }
}
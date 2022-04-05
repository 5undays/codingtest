package interview;

import java.util.*;

import interview.entity.Node;

public class CircleLinkedList {
    private Node head;

    public static void main(String[] args) {
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        circleLinkedList.example1();
    }

    public void example1() {
        Node node = new Node();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        node.value = 1;
        node.next = node1;
        node1.value = 2;
        node1.next = node2;
        node2.value = 3;
        node2.next = node3;
        node3.value = 1;
        node3.next = node;
        this.head = node;
        boolean isCircle = hasCircle();
        System.out.println(isCircle);
        Node startNode = startCircle();
        System.out.println(startNode.value);
    }

    // 원형 연결 리스트 인지 검사 (반복)
    private boolean hasCircle() {
        Set<Node> nodeSet = new HashSet<>();
        Node current = this.head;
        while (current != null) {
            if (nodeSet.contains(current)) {
                return true;
            } else {
                nodeSet.add(current);
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

    // 원형 연결 리스트의 시작 지점 찾기
    private Node startCircle() {
        Set<Node> nodeSet = new HashSet<>();
        Node current = this.head;
        while (current != null) {
            if (nodeSet.contains(current)) {
                return current;
            } else {
                nodeSet.add(current);
            }
            current = current.next;
        }
        return current;
    }
}
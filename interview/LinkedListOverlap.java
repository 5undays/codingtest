package interview;

import java.util.*;

public class LinkedLitOverlap {

    class Node {
        private Node head;
        private Node tail;
        private int value;
    }
    public static void main (String[] args) {
        Node node = new Node();
        node.value = 2;
        node.left = new Node();
    }

    private void removeDuplicatesIterator() {
        Node current = this.head;
        while (current != null) {
            Node temp = current;
            // 중복 제거
            while (temp != null && temp.value == current.value) {
                temp = temp.next;
            }

            // 다음 노트 설정
            current.next = temp;
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
}
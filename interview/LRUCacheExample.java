package interview;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LRUCacheExample {

    private int cacheSize;

    private HashMap<Integer, Node> map;

    private Node head, tail;

    class Node {
        Node prev;
        Node next;
        int value;
    }

    private void query(int number) {
        if (map.containsKey(number)) {
            Node node = map.get(number);
            remove(node);
            addToHead(node);
        } else {
            Node nodeToAdd = new Node();
            nodeToAdd.value = number;
            if (map.size() == this.cacheSize) {
                map.remove(tail.value);
                remove(tail);
            }
            addToHead(nodeToAdd);
            map.put(number, nodeToAdd);
        }
    }

    LinkedHashSet<Integer> cache = new LinkedHashSet<>();

    private void query2(int number) {
        if (!cache.contains(number)) {
            if (cache.size() == cacheSize) {
                int firstKey = cache.iterator().next();
                cache.remove(firstKey);
            }
            cache.add(number);
        }

        cache.remove(number);
        cache.add(number);
    }

    private void print2() {
        System.out.println(cache);
    }

    private void addToHead(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }

        head = node;

        if (tail == null) {
            tail = head;
        }
    }

    private void remove(Node node) {
        if (node.prev != null) { // head 가 아닌 경우
            node.next.next = node.next;
        } else { // head 인 경우
            head = node.next;
        }

        if (node.next != null) { // 마지막 노드 아닌 경우
            node.next.prev = node.prev;
        } else { // 마지막 노드 인경우
            tail = node.prev;
        }
    }

    private void print() {
        Node current = this.head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}

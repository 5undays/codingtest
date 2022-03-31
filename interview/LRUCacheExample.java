package interview;

import java.util.HashMap;
import java.util.LinkedHashSet;
import interview.entity.Node;

/**
 * Least Recently Used Cache
 */
public class LRUCacheExample {
    private int cacheSize = 5;
    private Node head, tail;

    private HashMap<Integer, Node> map = new HashMap<>(); // LRU Double LinkedList

    /**
     * HashMap 을 사용한 LRU
     * 
     * @param number 1~100 까지의 숫자
     */
    private void query(int number) {
        if (map.containsKey(number)) { // 이미 존재
            Node node = map.get(number);
            remove(node); // 이미 존재하는 노드를 지워줌
            addToHead(node); // 초기 노드로 설정
        } else { // 처음 입력
            Node nodeToAdd = new Node();
            nodeToAdd.value = number;
            // 사이즈가 같으면 마지막 데이터를 지워주어야 한다.
            if (map.size() == this.cacheSize) {
                map.remove(tail.value);
                remove(tail);
            }
            addToHead(nodeToAdd); // 초기 노드 설정
            map.put(number, nodeToAdd);
        }
    }

    /**
     * LinkedHashSet (순서 보장) 을 사용한 LRU
     * 
     * @param number
     */
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

    /**
     * 초기 노드 설정
     * 
     * @param node
     */
    private void addToHead(Node node) {
        node.next = head;
        node.prev = null;

        // 처음에 입력된 노드가 아닌 경우
        if (head != null) {
            // 처음 입력 된 노드 앞에 입력할 노드가 앞으로 간다
            head.prev = node;
        }

        head = node;

        // 마지막 노드가 없을 경우
        if (tail == null) {
            // 마지막 노드로 설정
            tail = head;
        }
    }

    /**
     * 노드 삭제
     * 
     * @param node
     */
    private void remove(Node node) {
        System.out.println("remove node : " + node.value);
        if (node.prev != null) { // head 가 아닌 경우
            node.prev.next = node.next;
        } else { // head 인 경우
            head = node.next;
        }

        if (node.next != null) { // 마지막 노드 아닌 경우
            node.prev.next = node.prev;
        } else { // 마지막 노드 인경우
            tail = node.prev;
        }
    }

    private void print2() {
        System.out.println(cache);
    }

    private void print() {
        Node current = this.head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void main(String args[]) {
        LRUCacheExample example = new LRUCacheExample();
        example.query(1);
        example.query(2);
        example.query(3);
        example.query(4);
        example.query(5);
        example.query(6);
        example.print();
    }
}

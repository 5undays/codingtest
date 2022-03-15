package interview;

import java.util.HashMap;
import java.util.Map;

public class BinaryTree {

    class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    int preIndex = 0;

    Map<Integer, Integer> indexMap = new HashMap<>();

    /**
     * 중위 탐색 전위 탐색 결과로 이진트리 생성
     * @param inOrder  중위 탐색 배열
     * @param preOrder 전위 탐색 배열
     * @param startIdx 시작 인덱스
     * @param endIdx   종료 인덱스
     * @return 이진 트리 
     */
    private Node buildRecurse(int[] inOrder, int[] preOrder, int startIdx, int endIdx) {
        if (startIdx > endIdx) {
            return null;
        }

        Node node = new Node(preOrder[preIndex++]);

        if (startIdx == endIdx) {
            return node;
        }

        int inIdx = indexMap.get(node.value);
        node.left = buildRecurse(inOrder, preOrder, startIdx, inIdx - 1);
        node.right = buildRecurse(inOrder, preOrder, startIdx + 1, endIdx);
        return node;
    }
}

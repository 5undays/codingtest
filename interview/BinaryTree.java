package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import interview.entity.Graph;

public class BinaryTree {

    int preIndex = 0;

    Map<Integer, Integer> indexMap = new HashMap<>();

    /**
     * 중위 탐색 & 전위 탐색 결과로 이진트리 생성
     * 
     * @param inOrder  중위 탐색 배열
     * @param preOrder 전위 탐색 배열
     * @param startIdx 시작 인덱스
     * @param endIdx   종료 인덱스
     * @return 이진 트리
     */
    private Graph buildRecurse(int[] inOrder, int[] preOrder, int startIdx, int endIdx) {
        if (startIdx > endIdx) {
            return null;
        }

        Graph node = new Graph(preOrder[preIndex++]);

        if (startIdx == endIdx) {
            return node;
        }

        int inIdx = indexMap.get(node.value);
        node.left = buildRecurse(inOrder, preOrder, startIdx, inIdx - 1);
        node.right = buildRecurse(inOrder, preOrder, startIdx + 1, endIdx);
        return node;
    }

    /**
     * 이진 트리의 계층 별 합 중 최대 값을 구하기
     * @param root 최초 노드
     * @return 계층 별 합 중 최대 값
     */
    private int maxSum(Graph root) {
        if (root == null)
            return 0;
        int result = root.value;
        Queue<Graph> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            int sum = 0;
            while (count-- > 0) {
                count--;
                Graph node = queue.poll();
                sum += node.value;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result = Math.max(sum, result);
        }
        return result;
    }

    private int count = 0;

    // POSTFIX 에서 N번째 index에 해당하는 값을 출력
    private void print(Graph root, int index) {
        if (root != null) {
            print(root.left, index);
            print(root.right, index);

            if (count++ == index - 1) {
                System.out.println(root.value);
            }
        }
    }

    /**
     * 가장 가까운 공통 조상 찾기 (Lowest Common Ancestor)
     * 
     * @param root 루트 노드
     * @param n1   비교 노드 1
     * @param n2   비교 노드 2
     * @return 가장 가까운 노드
     */
    private Graph solution(Graph root, int n1, int n2) {
        List<Graph> n1Path = new ArrayList<>();
        List<Graph> n2Path = new ArrayList<>();

        if (!findPath(root, n1, n1Path) || !findPath(root, n2, n2Path)) {
            return null;
        }

        int index = 0;

        for (; index < n1Path.size() && index < n2Path.size(); index++) {
            if (!n1Path.get(index).equals(n2Path.get(index))) {
                break;
            }
        }
        return n1Path.get(index - 1);
    }

    /**
     * 경로 여부
     * 
     * @param root 루트 노드
     * @param n    현재 노드
     * @param path 현재 노드에서 경로
     * @return 경로 존재 여부
     */
    private boolean findPath(Graph root, int n, List<Graph> path) {
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root.value == n) { // 찾는 노드
            return true;
        }

        if (findPath(root.left, n, path)) {
            return true;
        }

        if (findPath(root.right, n, path)) {
            return true;
        }

        path.remove(root);
        return false;
    }

    // 가장 가까운 조상 찾기 (bindaryTree 의 경우)
    private Graph solution2(Graph root, int n1, int n2) {
        if (root == null)
            return null;
        if (root.value == n1 || root.value == n2)
            return root;

        Graph leftCLA = solution2(root.left, n1, n2);
        Graph rightCLA = solution2(root.right, n1, n2);

        if (leftCLA != null && rightCLA != null) {
            return root;
        }
        return (leftCLA != null) ? leftCLA : rightCLA;
    }

    /**
     * 가장 가까운 조상 찾기 (BST)
     * 
     * @param root
     * @param n1
     * @param n2
     * @return
     */
    private Graph solution3(Graph root, int n1, int n2) {
        if (root == null)
            return null;
        int value = root.value;
        if (value < n1 && value < n2) {
            return solution3(root.right, n1, n2);
        }
        if (value > n1 && value > n2) {
            return solution3(root.left, n1, n2);
        }
        return root;
    }

    /**
     * BST 인지 확인
     * 
     * @param node 노드
     * @return
     */
    private boolean isBST(Graph node) {
        if (node == null) {
            return true;
        }

        if (node.left != null && node.left.value > node.value) {
            return false;
        }

        if (node.right != null && node.right.value < node.value) {
            return false;
        }

        if (!isBST(node.left) || !isBST(node.right)) {
            return false;
        }
        return true;
    }

    private Graph prevNode;

    private boolean isBST2(Graph node) {
        if (node != null) {
            if (!isBST2(node.left)) {
                return false;
            }

            if (prevNode != null && node.value <= prevNode.value) {
                return false;
            }
            prevNode = node;
            return isBST2(node.right);
        }

        return true;
    }

}

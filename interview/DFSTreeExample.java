package interview;

import java.util.Stack;

public class DFSTreeExample {

    static private class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        DFSTreeExample example = new DFSTreeExample();
        example.preOrder(root);
        //example.inOrder(root);
        //example.postOrder(root);
    }

    // preorder iterator
    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            System.out.println(root.value);
            // right 항목은 left 보다 나중에 처리 되어야 함
            if (root.right != null){
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

    // inorder iteration
    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        
        Stack<Node> stack = new Stack<>();
        
        while(true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            if (stack.isEmpty()) {
                break;
            }
            
            root = stack.pop();
            System.out.println(root.value);
            root = root.right;
        }
    }

    // post-Order iteration
    private void postOrder(Node root) {
        if (root == null) {
            return;
        }
        
        // 빈 스택을 생성한다
        Stack<Node> stack = new Stack<>();
        
        while(true) {
            while (root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }
            
            if (stack.isEmpty()) {
                break;
            }
            
            root = stack.pop();
            // root를 두번 넣어 root.right 항목을 출력보다 먼저 처리 할수 있게 함
            if (!stack.isEmpty() && stack.peek() == root) {
                root = root.right;
            } else {
                System.out.println(root.value);
                root = null; // 터미널 노드 초기화 필수
            }
        }
    }
    

    // pre-order Recursive
    private void preOrder2(Node root) {
        if (root != null) {
            preOrder2(root.left);
            preOrder2(root);
            preOrder2(root.right);
        }
    }

    // inorder Recursive
    private void inOrder2(Node root) {
        if (root != null) {
            inOrder2(root.left);
            inOrder2(root);
            inOrder2(root.right);
        }
    }

    // post-order Recursive
    private void postOrder2(Node root) {
        if (root != null) {
            postOrder2(root.left);
            postOrder2(root.right);
            postOrder2(root);
        }
    }

}

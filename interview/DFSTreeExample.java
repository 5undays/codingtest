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

        DFSTreeExample treeIntro = new DFSTreeExample();
        treeIntro.inOrder(root);
        //treeIntro.preOrder(root);
    }

    // pre-order iteration
    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        
        Stack<Node> stack = new Stack<>();
        
        while(true) {
            while (root != null) {
                stack.push(root);
                //root = root.left;
            }
            
            if (stack.isEmpty()) {
                break;
            }
            
            root = stack.pop();
            System.out.println(root.value);
            root = root.right;
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

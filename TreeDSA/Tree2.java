package TreeDSA;

import java.util.LinkedList;
import java.util.Queue;

public class Tree2 extends Tree {
    // Tree traversal algorithms
    // 1. Preorder
    public void preOrderTraversal(int p) {
        // recursive approach: current parent node + all left child nodes + all right
        // child nodes

        System.out.print(T[p] + " ");
        if (hasLeftChild(p)) {
            preOrderTraversal(2 * p + 1);
        }
        if (hasRightChild(p)) {
            preOrderTraversal(2 * p + 2);
        }
    }
    // 2. Inorder

    public void inOrderTraversal(int p) {
        // recursive approach: left child node + parent node + right child node
        if (hasLeftChild(p)) {
            inOrderTraversal(2 * p + 1);
        }
        System.out.print(T[p] + " ");
        if (hasRightChild(p)) {
            inOrderTraversal(2 * p + 2);
        }

    }

    // 3. Postorder
    public void postOrderTraversal(int p) {
        // recursive approach: all left child nodes + all right child nodes + current
        // parent node
        if (hasLeftChild(p)) {
            postOrderTraversal(2 * p + 1);
        }
        if (hasRightChild(p)) {
            postOrderTraversal(2 * p + 2);
        }
        System.out.print(T[p] + " ");

    }

    // 4. Breadth-first
    public void breadthFirstTraversal(int p) {
        if (isEmpty()) {

            System.out.println("Tree is empty.");
        }
        Queue<Integer> queue = new LinkedList<>();

        queue.add(p);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(T[node] + " ");
            if (hasLeftChild(node)) {
                queue.add(2 * node + 1);
            }
            if (hasRightChild(node)) {
                queue.add(2 * node + 2);
            }
        }
    }
}
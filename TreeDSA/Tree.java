package TreeDSA;

import java.util.Arrays;
import java.util.Scanner;

public class Tree {
    // default tree's capacity
    protected final int treeCapacity = 64;
    protected int size = 0;
    // array to keep tree data
    protected int[] T;

    public Tree() {
        T = new int[treeCapacity];
        // fill array with -1
        Arrays.fill(T, -1);
    }

    public Tree(int tSize) {
        T = new int[tSize];
        // fill array with -1
        Arrays.fill(T, -1);
    }

    // is current node a root?
    public boolean isRoot(int p) {
        if (p == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasLeftChild(int p) {
        // is node p has a left child?
        if (T[2 * p + 1] != -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasRightChild(int p) {
        // is node p has a right child?
        if (T[2 * p + 2] != -1) {
            return true;
        } else {
            return false;
        }
    }

    public int getsize() {
        // return tree's size
        return size;
    }

    public boolean isEmpty() {
        // is tree empty?
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getElement(int p) {
        // is node p existed?
        if (T[p] > -1) {
            return T[p];
        } else {
            return -999; // Return -999 if the node is empty
        }
    }

    public boolean isInternal(int p) {
        // if either left or right child node exists
        return hasLeftChild(p) || hasRightChild(p);
    }

    public boolean isLeaf(int p) {
        // left and right child nodes are blank (-1)
        return !hasLeftChild(p) && !hasRightChild(p);
    }

    public int getParent(int p) {
        // return value of parent node of node p
        if (isRoot(p)) {
            return -999;
        }
        return (p - 1) / 2;
    }

    // print all nodes' positions
    public void printAllPositions() {
        System.out.print("\nAll positions are :");
        for (int i = 0; i < T.length; i++) {
            if (T[i] > -1) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // print all nodes' elements (Breadth-First)
    public void printAllElements() {
        System.out.print("\nAll elements are :");
        for (int i = 0; i < T.length; i++) {
            if (T[i] != -1) {
                System.out.print(T[i] + " ");
            }
        }
        System.out.println();
    }

    public void addRoot(int element) {
        if (isEmpty()) {
            T[0] = element;
            System.out.println("Root of T was added");
            size++;
        } else {
            System.out.println("Tree is not empty.");
        }
    }

    public void addChild(int p, int element) {
        // add left or right
        // add left or right child
        if (element < T[p]) { // left child
            if (hasLeftChild(p)) { // p has left child?
                // compare value of left child with element
                addChild(2 * p + 1, element);
            } else {// p has no left child
                T[2 * p + 1] = element;
                System.out.println("Left child of " + p + " was added");
                size++;
            }
        } else {// right child
            if (hasRightChild(p)) { // p has right child?
                // compare value of right child with element
                addChild(2 * p + 2, element);
            } else {// p has no right child
                T[2 * p + 2] = element;
                System.out.println("Right child of " + p + " was added");
                size++;
            }
        }
    }

    public int getLeftChild(int p) {
        // has left child?
        int leftChildIndex = 2 * p + 1;
        if (hasLeftChild(p)) {
            return T[leftChildIndex];
        }
        return -999; // Return -999 if no left child exists
    }

    public int getRightChild(int p) {
        // has right child?
        int rightChildIndex = 2 * p + 2;
        if (hasRightChild(p)) {
            return T[rightChildIndex];
        }
        return -999; // Return -999 if no right child exists
    }

    public int getSibling(int p) {
        if (isRoot(p)) {
            return -999; // Root has no sibling   
        } else if (p % 2 == 1) {// p is left child , then find right child of the same parent
            if (T[p + 1] > -1) {
                return T[p + 1];
            }
        } else if (p % 2 == 0) {// p is right child , then find left child of the same parent
            if (T[p - 1] > -1) {
                return T[p - 1];
            }
        }
        return -999; // Return -999 if no sibling exists
    }

    public static void main(String[] args) {
        int element, amount;
        System.out.println("How many data do you want to store in tree? ... ");
        Scanner keyboard = new Scanner(System.in);
        amount = keyboard.nextInt();

        Tree abt = new Tree();
        System.out.println("\nTree constructing ... \n");
        System.out.println("First the tree is empty: " + abt.isEmpty());
        for (int i = 0; i < amount; i++) {
            System.out.print("Enter data#" + (i + 1) + " :");
            element = keyboard.nextInt();
            if (abt.isEmpty()) {
                abt.addRoot(element);
            } else {
                abt.addChild(0, element);
            }
        }
        abt.printAllPositions();
        abt.printAllElements();
        System.out.println();

        System.out.println("The value in root node = " + abt.getElement(0));
        System.out
                .println("Node 1 contains " + abt.getElement(1) + " and it is an internal node: " + abt.isInternal(1));
        System.out.println("Node 3 contains " + abt.getElement(3) + " and it is a leaf node: " + abt.isLeaf(3));
        System.out.println("Node 6 contains " + abt.getElement(6) + ", its left child value = " + abt.getLeftChild(6)
                + " and its right child value = " + abt.getRightChild(6));
        System.out.println("Node 2 contains " + abt.getElement(2) + " and its sibling value = " + abt.getSibling(2));
        System.out.println("Node 29 contains " + abt.getElement(29) + " and its parent value = "
                + abt.getElement(abt.getParent(29)));

        System.out.println();
        System.out.println("Finally the tree's size = " + abt.getsize());
        keyboard.close();
    }
}

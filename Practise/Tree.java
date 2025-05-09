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
        if(p == 0){
            return true;
        }
        return false; 
    }

    public boolean hasLeftChild(int p) {
        if(T[(2* p) + 1] > -1){
            return true;
        }
        return false; // Remove the implementation logic here.
    }

    public boolean hasRightChild(int p) {
        if(T[(2*p) + 2] > -1 ){
            return true;
        }
        return false; // Remove the implementation logic here.
    }

    public int getsize() {
        return size; // Return the size appropriately
    }

    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false; // Check if tree is empty
    }

    public int getElement(int p) {
        if(T[p] > -1){
            return T[p];
        }
        return -999; // Return a default or error value
    }

    public boolean isInternal(int p) {
        if(hasLeftChild(p) || hasRightChild(p)){
            return true;
        }
        return false; // Check if node is internal
    }

    public boolean isLeaf(int p) {
        if(hasLeftChild(p) || hasRightChild(p)){
            return false;
        }
        return true; // Check if node is leaf
    }

    public int getParent(int p) {
        if(isRoot(p)){
            return -999;
        }
        return T[(p-1)/2]; // Return appropriate value for parent
    }

    // print all nodes' positions
    public void printAllPositions() {
        // Method logic removed
        for (int i = 0; i < T.length; i++) {
            if(T[i] > -1){
                System.out.println(i + " ");
            }
        }
    }

    // print all nodes' elements (Breadth-First)
    public void printAllElements() {
        // Method logic removed
        for (int i = 0; i < T.length; i++) {
            if(T[i] != -1){
                System.out.println(T[i] + " ");
            }
        }
    }

    public void addRoot(int element) {
        // Root adding logic removed
        if(isEmpty()){
            T[0] = element;
            size++;
            System.out.println("Root of T was added");
        }else{
            System.out.println("Tree is not empty.");
        }
        
    }

    public void addChild(int p, int element) {
        // Child adding logic removed
        if(element > T[p]){
            if(hasLeftChild(p)){
                addChild(2 * p + 1, element);
            }else{
                T[(2*p) + 1] = element;
                size++;
                System.out.println("Left child of " + p + " was added");
            }
        }else{
            if(hasRightChild(p)){
                addChild(2 * p + 2, element);
            }else{
                T[(2*p) + 2] = element;
                size++;
                System.out.println("Right child of " + p + " was added");
            }
        }
    }

    public int getLeftChild(int p) {
        if(hasLeftChild(p)){
            return T[(2*p) + 1];
        }
        return -999; // Return appropriate value for left child
    }

    public int getRightChild(int p) {
        if(hasRightChild(p)){
            return T[(2*p) + 2];
        }
        return -999; // Return appropriate value for right child
    }

    public int getSibling(int p) {
        if(isRoot(p)){
            return -999; // Return appropriate value for sibling
        }else{
            if(p % 2 == 1){
                //left child
                if(T[p+1] > -1){
                    return T[p + 1];
                }
            }else if(p%2 == 0){
                //right child
                if(T[p-1] > -1){
                    return T[p -1];
                }
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

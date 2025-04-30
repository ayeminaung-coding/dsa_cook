public class CircularArrayQueue {
    private int CAPACITY = 10;
    private int[] data;
    private int front;
    private int size;

    public CircularArrayQueue() {
        data = new int[CAPACITY];
    }

    public CircularArrayQueue(int capacity) {
        data = new int[capacity];
        front = 0;
        size = 0;
    }

    public void enqueue(int element) {
        if (size == data.length) {
            System.out.println("Queue is full");
        } else {
            data[(front + size) % data.length] = element;
            size++;
        }
    }

    public int dequeue() {
        if (size == 0) {
            return -999;
        } else {
            int firstElement = data[front];
            front = (front + 1) % data.length;
            size--;
            return firstElement;
        }
    }

    public int peek() {
        if (isEmpty()) {
            return -999;
        } else {
            return data[front];
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void printQueue() {
        if (size == 0) {
            System.out.println("Queue is empty");
        } else {
            int temp = front;
            System.out.print("Queue: ");
            for (int i = 0; i < size; i++) {
                System.out.print(data[temp] + " ");
                temp = (temp + 1) % data.length;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularArrayQueue queue = new CircularArrayQueue(12);
        queue.printQueue();
        System.out.println();
        // Enqueue 5 elements
        System.out.println("### Add Data to Empty queue ###");
        System.out.print("enqueue() :");
        for (int i = 1; i <= 5; i++) {
            queue.enqueue(i);
            System.out.print(" " + i);
        }
        System.out.println();
        queue.printQueue();
        System.out.println();
        // Dequeue 3 elements
        System.out.println("------ Remove the 3 elements from Queue ------");
        for (int i = 1; i <= 3; i++) {
            System.out.println("dequeue() : " + queue.dequeue());
            queue.printQueue();
            System.out.println();
        }
        // Peek
        System.out.println("First element is " + queue.peek());
        System.out.println();
        // Add 10 more elements
        System.out.println("+++ Add more Data to Queue +++");
        System.out.print("enqueue() :");
        for (int i = 10; i <= 100; i += 10) {
            queue.enqueue(i);
            System.out.print(" " + i);
        }
        System.out.println();
        queue.printQueue();
        System.out.println();
        // Test queue full
        System.out.println("+++ Add more Data to Queue +++");
        System.out.println("enqueue() : 110");
        queue.enqueue(110);
        System.out.println("\n+++ Dequeue all data : +++");
        System.out.print("Remove ");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();
        queue.printQueue();
    }
}

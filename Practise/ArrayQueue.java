public class ArrayQueue {
    private int CAPACITY = 10;
    private int[] data;
    private int front;
    private int size;

    public ArrayQueue() {
        data = new int[CAPACITY];
    }

    public ArrayQueue(int capacity) {
        data = new int[capacity];
        front = 0;
        size = 0;
    }

    public void enqueue(int element) {
        if ((size + front) == data.length) {
            System.out.println("Queue is full");
        } else {
            data[front + size] = element;
            size++;
        }
    }

    public int dequeue() {
        if (size == 0) {
            return -999;
        } else {
            int firstElement = data[front];
            front++;
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
        System.out.println("Queue.. :");
        for (int i = front; i < front + size; i++) {
            System.out.print(data[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(6);
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
        // Peek
        System.out.println("First element is " + queue.peek());
        System.out.println();
        // Remove 3 elements
        System.out.println("------ Remove 3 elements from Queue ------");
        for (int i = 1; i <= 3; i++) {
            System.out.println("dequeue() : " + queue.dequeue());
            queue.printQueue();
            System.out.println();
        }
        // Peek
        System.out.println("First element is " + queue.peek());
        System.out.println();
        // Add 2 more elements
        System.out.println("+++ Add more Data to Queue +++");
        System.out.println("enqueue() : 10");
        queue.enqueue(10);
        queue.printQueue();
        System.out.println();
        System.out.println("enqueue() : 20");
        queue.enqueue(20);
        queue.printQueue();
        System.out.println();
        System.out.println("+++ Dequeue all data : +++");
        System.out.print("Remove ");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();
        queue.printQueue();
    }
}
package first_sem_dsa;
class SLL {
    // ----------------------- Node --------------------
    private class Node {
        private int element;
        private Node next;

        // constructor
        public Node(int data) {
            element = data;
            next = null;
        }

        // link a new node to this node
        public void link(Node newNode) {
            next = newNode;
        }

        // return next node
        public Node getNextNode() {
            return next;
        }

        // return element of this node
        public int getElement() {
            return element;
        }
    }
    // --------------------- End Node --------------------

    // SLL properties and methods
    private Node head = null;
    private Node tail = null;
    private int size = 0; // SLL's size

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        boolean empty = false;
        if (size == 0) {
            empty = true;
        }
        return empty;
    }

    public void addLast(int data) {
        // create new node
        Node newNode = new Node(data);
        if (size == 0) {
            head = newNode;
        } else {
            tail.link(newNode);
        }
        tail = newNode;
        size++;
    }

    public int get(int index) {
        if (size == 0) {
            System.out.println("Empty linked list");
        } else {
            Node p = head;
            for (int i = 0; i < index; i++) {
                p = p.getNextNode();
            }
            return p.getElement();
        }
        return -1;
    }

    public void clear() {
        size = 0;
        tail = null;
        head = null;
    }

    public void print() {
        if (size == 0) {
            System.out.println("Empty linked list");
        } else {
            for (Node p = head; p != null; p = p.getNextNode()) {
                System.out.print(p.getElement() + "->");
            }
            System.out.println("null");
        }
    }

    public boolean findElement(int element) {
        Node p = head;
        int index = 0;
        boolean found = false;
        while (p != null) {
            if (p.getElement() == element) {
                found = true;
                break;
            }
            p = p.getNextNode();
            index++;
        }
        return found;
    }

    public int countElement(int element) {
        Node p = head;
        int count = 0;
        while (p != null) {
            if (p.getElement() == element) {
                count++;
            }
            p = p.getNextNode();
        }
        return count;
    }

    public void addFirst(int data) {
        // create new node
        Node newNode = new Node(data);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.link(head);
        }
        head = newNode;
        size++;
    }

    public int sumElement() {
        Node p = head;
        int sum = 0;
        while (p != null) {
            sum += p.getElement();
            p = p.getNextNode();
        }
        return sum;
    }

    public static void main(String[] args) {
        SLL sll = new SLL();
        sll.addFirst(11);
        sll.addLast(22);
        sll.addLast(11);
        sll.print();

        System.out.println();
        System.out.println("Find element 11: " + sll.findElement(11));
        System.out.println("Find element 22: " + sll.findElement(22));
        System.out.println("Find element 33: " + sll.findElement(33));
        System.out.println("Count element 11: " + sll.countElement(11));
        System.out.println("Count element 22: " + sll.countElement(22));
        System.out.println("Count element 33: " + sll.countElement(33));
        System.out.println("Sum of all elements: " + sll.sumElement());
    }
}

// ======================== Main Class =======================
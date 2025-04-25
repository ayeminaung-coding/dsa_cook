public class Graph {
    private final int MAX_VERTICES = 20; // allow only 20 vertices
    private char[] vertex; // list of vertices
    private int[][] adjMatrix; // adjacency matrix
    private int numVertices; // number of vertices
    private int numEdges;

    // default constructor
    public Graph() {
        // create vertex objects
        vertex = new char[MAX_VERTICES];
        // create adjacency matrix objects
        adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        numVertices = 0;
        numEdges = 0;

        // set all elements of adjacency matrix to be zero (no edges)
        for (int i = 0; i < MAX_VERTICES; i++) {
            for (int j = 0; j < MAX_VERTICES; j++) {
                adjMatrix[i][j] = 0;
            }
        }
    }

    // add new vertex with title
    public void addVertex(char title) {
        vertex[numVertices++] = title;
    }

    // add edge between two vertices
    public void addEdge(int start, int end) {
        // set value in adjacency matrix adjMatrix
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
        numEdges++;
    }

    // graph's size
    public void showSize() {
        System.out.println("Size of graph = " + numVertices);
        System.out.println();
    }

    // display each vertex's title
    public void showVertex() {
        System.out.println("=== Vertexes ===");
        for (int i = 0; i < vertex.length; i++) {
            System.out.print(vertex[i] + " ");
        }
        System.out.println("\n");
    }

    // display adjacency matrix
    public void showAdjacency() {
        System.out.println("=== Adjacency Matrix ===");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("");
    }

    // display all edges
    public void showEdge() {
        System.out.println("=== Edges ===");
        System.out.println("Number of edges = " + numEdges);
        for (int i = 0; i < numVertices; i++) {
            for (int j = i; j < numVertices; j++) {
                if (adjMatrix[i][j] == 1) {
                    System.out.print(vertex[i] + "-" + vertex[j] + " ");
                }
            }
        }
        System.out.println("\n");
    }

    // check if the graph complete?
    public void checkComplete() {
        int complete = numVertices * (numVertices - 1) / 2;
        if (numEdges == complete) {
            System.out.println("This graph is a Complete Graph");
        } else {
            System.out.println("This graph is NOT a complete graph");
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        // create vertices
        graph.addVertex('A'); // 0
        graph.addVertex('B');// 1
        graph.addVertex('C');// 2
        graph.addVertex('D'); // 3
        graph.addVertex('E'); // 4
        graph.addVertex('F'); // 5
        graph.addVertex('G'); // 6
        graph.addVertex('H');// 7
        graph.addVertex('I');// 8

        // connect vertices
        graph.addEdge(0, 1); // AB
        graph.addEdge(0, 2); // AC
        graph.addEdge(0, 3); // AD
        graph.addEdge(0, 4); // AE
        graph.addEdge(1, 5); // BF
        graph.addEdge(5, 7); // FH
        graph.addEdge(3, 6); // DG
        graph.addEdge(6, 8); // GI

        // size
        graph.showSize();

        // show vertexes
        graph.showVertex();

        // show adjacency matrix
        graph.showAdjacency();

        // show edges
        graph.showEdge();

        // a complete graph?
        graph.checkComplete();
    }

}

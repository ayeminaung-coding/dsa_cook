public class DiGraph {
    private final int MAX_VERTICES = 20; // allow only 20 vertices
    private char[] vertex; // list of vertices
    private int[][] adjMatrix; // adjacency matrix
    private int numVertices; // number of vertices
    private int numEdges;

    // default constructor
    public DiGraph() {
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
    public void addEdge(int start, int end, int weight) {
        // set value in adjacency matrix
        adjMatrix[start][end] = weight;
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
            for (int j = 0; j < numVertices; j++) {
                if (adjMatrix[i][j] > 0) {
                    System.out.print(vertex[i] + "-" +
                            vertex[j] + "(" + adjMatrix[i][j] + ") ");
                }
            }
        }
        System.out.println("\n");
    }

    // check if the graph complete?
    public void checkComplete() {
        int complete = numVertices * (numVertices - 1);
        if (numEdges == complete) {
            System.out.println("This graph is a Complete Graph");
        } else {
            System.out.println("This graph is NOT a complete graph\n");
        }
    }

    // compute path length
    public int findPathLength(int[] path) {
        int pathlength = 0;
        for (int i = 0; i < path.length - 1; i++) {
            int start = path[i];
            int end = path[i + 1];
            pathlength += adjMatrix[start][end];
        }
        return pathlength;
    }

    public static void main(String[] args) {
        DiGraph graph = new DiGraph();

        // create vertices
        graph.addVertex('A'); // 0
        graph.addVertex('B');// 1
        graph.addVertex('C');// 2
        graph.addVertex('D'); // 3
        graph.addVertex('E'); // 4

        // connect vertices
        graph.addEdge(0, 1, 3); // AB weight = 3
        graph.addEdge(0, 2, 4); // AC weight = 4
        graph.addEdge(0, 3, 1); // AD weight = 1
        graph.addEdge(1, 4, 2); // BE weight = 2
        graph.addEdge(2, 3, 3); // CD weight = 3
        graph.addEdge(3, 1, 2); // DB weight = 2
        graph.addEdge(3, 2, 3); // DC weight = 3
        graph.addEdge(4, 2, 4); // EC weight = 4

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

        // weighted path length
        // ABECD
        int[] path = { 0, 1, 4, 2, 3 };
        System.out.println("The path length ABECD = " + graph.findPathLength(path));
    }

}

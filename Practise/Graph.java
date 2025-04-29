public class Graph {
    public final int MAX_VERTICES = 20; // allow only 20 vertices
    private char[] vertex; // list of vertices
    private int[][] adjMatrix; 
    private int numVertices;
    private int numEdges;    // Constructor
    public Graph() {
        // Initialization code here
        vertex = new char[MAX_VERTICES];
        adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        numVertices = 0;
        numEdges = 0;

        for(int i = 0; i < MAX_VERTICES; i++){
            for(int j = 0 ; j < MAX_VERTICES; j++){
                adjMatrix[i][j] = 0;
            }
        }
    }

    // Add methods and properties as needed

    // Add new vertex with title
    public void addVertex(char title) {
        vertex[numVertices++] = title;
    }

    public void addEdge(int start, int end){
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
        numEdges++;
    }

    // graph size
    public void showSize(){
        System.out.println("Size of graph = " + numVertices);
    }

    public void showVertex(){
        System.out.println("== Vertexes ===");
        for (int i = 0; i < vertex.length; i++) {
            System.out.println(vertex[i] + " ");
        }
        System.out.println("\n");
    }
    
    public void showAdjacency(){
        System.out.println("== Adjacency Matrix ===");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if(adjMatrix[i][j] == 1){
                    System.out.print(vertex[i] + "-" + vertex[j] + " ");
                }
            }
        }
        System.out.println("\n");
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

    public void checkComplete(){
        int complete = numVertices * (numVertices -1 ) /2;
        if(numEdges == complete){
            System.out.println("This graph is a complete graph");
        }else {
            System.out.println("This graph is NOT a complete graph");
        }
    }

    public static void main(String[] args){
        Graph graph = new Graph();
        //create vertices
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');
        graph.addVertex('I');

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
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


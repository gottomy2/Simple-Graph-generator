import java.sql.SQLOutput;

public class Graph {
    private final int nodes; // Defines how many nodes exist within a graph;
    private final int[][] matrix; // Matrix representation of graph
    private final boolean[][] isSet; // Defines if position has been already set.

    public Graph(int nodes) {
        this.nodes = nodes;
        matrix = new int[nodes][nodes];
        isSet = new boolean[nodes][nodes];
    }

    public void addEdge(int input,int output){
        matrix[input][output] = 1;
        isSet[input][output] = true;
    }

    public void printMatrix() {
        System.out.println("---------------------");
        System.out.println("Matrix:\n");
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                // We only want to print the values of those positions that have been marked as set
                if (isSet[i][j])
                    System.out.format(String.valueOf(matrix[i][j]));
                else System.out.format("x");
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }

    public void printEdges() {
        System.out.println("Edges:\n");
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (isSet[i][j]) {
                    System.out.print("Node" + i + " -> " + "Node" + j + "\n");
                }
            }
        }
        System.out.println("---------------------");
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static Graph createGraph(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\imoto\\eclipse-workspace\\TreePathFinding\\src\\main\\java\\graph.txt"));
            String line = reader.readLine();

            //Creating nodes:

            int countNodes = Integer.parseInt(line);
            Graph graph = new Graph(countNodes+1);

            //PuttingEdgeValues:
            while(true){
                line = reader.readLine();
                if(line==null)
                    break;
                int node1 = Integer.parseInt(line.substring(0,line.indexOf("->")-1));
                int node2 = Integer.parseInt(line.substring(line.indexOf("->")+3,line.indexOf(":")));
                graph.addEdge(node1,node2);
            }
            return graph;
        }
        catch(IOException e){
            e.printStackTrace();
        }
        Graph graph = new Graph(0);
        return graph;
    }

//    public static String[] generateConnectionsArray(MutableValueGraph<String, Integer> weightedGraph){
//        String[] graphEdges = weightedGraph.edges().toString().split(",");
//        for (int i = 0; i < graphEdges.length; i++) {
//            if(graphEdges[i].contains("[") || graphEdges[i].contains("]")){
//                graphEdges[i] = graphEdges[i].replace("["," ");
//                graphEdges[i] = graphEdges[i].replace("]","");
//            }
//            graphEdges[i] = graphEdges[i].substring(2,graphEdges[i].length()-1);
//        }
//        return graphEdges;
//    }

    public static void main(String[] args) {
        // Creating new graph from txtFile:
//        MutableValueGraph<String, Integer> weightedGraph = createGraph();
//        System.out.println(weightedGraph);
//
////       Creates String[] with NodeX -> NodeY strings in it to paste on: http://www.webgraphviz.com/
//        String[] graphEdges = generateConnectionsArray(weightedGraph);
//        for (int i = 0; i < graphEdges.length; i++) {
//            System.out.println(graphEdges[i]);
//        }
        Graph graph = createGraph();
        graph.printMatrix();
        graph.printEdges();

//        Node<Integer> start = new Node<>(10);
//        Node<Integer> firstNeighbor = new Node<>(2);
//        start.connect(firstNeighbor);
//
//        Node<Integer> firstNeighborNeighbor = new Node<>(3);
//        firstNeighbor.connect(firstNeighborNeighbor);
//        firstNeighborNeighbor.connect(start);
//
//        Node<Integer> secondNeighbor = new Node<>(4);
//        start.connect(secondNeighbor);
    }
}

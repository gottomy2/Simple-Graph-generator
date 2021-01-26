import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static Graph createGraph(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\imoto\\eclipse-workspace\\TreePathFinding\\src\\main\\java\\graph.txt"));
            String line = reader.readLine();

            //Creating graph with nodes = number of nodes declared in 1st line of the file.
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

    public static void main(String[] args) {
        Graph graph = createGraph();
        graph.printMatrix();
        graph.printEdges();
    }
}

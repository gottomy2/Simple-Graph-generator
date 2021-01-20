import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraphBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static MutableValueGraph<String, Integer> createGraph(){
        MutableValueGraph<String, Integer> weightedGraph = ValueGraphBuilder.directed().build();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\imoto\\eclipse-workspace\\TreePathFinding\\src\\main\\java\\graph.txt"));
            String line = reader.readLine();

            //Creating nodes:
            int countNodes = Integer.parseInt(line);
            for (int i = 0; i < countNodes; i++) {
                weightedGraph.addNode("Node"+i);
            }

            //PuttingEdgeValues:
            while(true){
                line = reader.readLine();
                if(line==null)
                    break;
                String node1 = line.substring(0,line.indexOf("->"));
                String node2 = line.substring(line.indexOf("->")+2,line.indexOf(":"));
                Integer value = Integer.parseInt(line.substring(line.indexOf(":")+1,line.length()));
                weightedGraph.putEdgeValue(node1,node2,value);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return weightedGraph;
    }

    public static String[] generateGraph(MutableValueGraph<String, Integer> weightedGraph){
        String[] graphEdges = weightedGraph.edges().toString().split(",");
        for (int i = 0; i < graphEdges.length; i++) {
            if(graphEdges[i].contains("[") || graphEdges[i].contains("]")){
                graphEdges[i] = graphEdges[i].replace("["," ");
                graphEdges[i] = graphEdges[i].replace("]","");
            }
            graphEdges[i] = graphEdges[i].substring(2,graphEdges[i].length()-1);
        }
        return graphEdges;
    }

    public static void main(String[] args) {
        // Creating new graph from txtFile:
        MutableValueGraph<String, Integer> weightedGraph = createGraph();

//       Creates String[] with NodeX -> NodeY strings in it to paste on: http://www.webgraphviz.com/
        String[] graphEdges = generateGraph(weightedGraph);
        for (int i = 0; i < graphEdges.length; i++) {
            System.out.println(graphEdges[i]);
        }
    }
}

import java.io.*;

/** DynamicGraph base class for graphs. A graph is a set
*   of vertices and a set of edges. Vertices are
*   represented by integers from 0 to n - 1. Edges
*   are ordered pairs of vertices.
*   @author Koffman and Wolfgang
*/

public interface DynamicGraph<E> extends Graph{
    // Accessor Methods
  /** Return created vertex
     *  @param label is label
     *  @param weight is weight
     *  @return vertex

   */
  Vertex<E> newVertex (String label, double weight);
   /** Adds vertex.
    * @param new_vertex is vertex to be added.
    * */
  void addVertex (Vertex<E> new_vertex);
   /** Adds edge
    * @param vertexID1 is reference of vertex.
    * @param vertexID2 is reference of vertex.
    * @param weight is weight of connection.
    * 
    * */
  void addEdge (int vertexID1, int vertexID2, double weight);
      /** Removes edge
    * @param vertexID1 is reference of vertex.
    * @param vertexID2 is reference of vertex.
    * */
  void removeEdge (int vertexID1, int vertexID2);
   /** Removes vertex
    * @param vertexID is reference id of vertex
    * */
  void removeVertex (int vertexID);
   /** Removes vertex
    * @param label is label of vertex
    * */
  void removeVertex (String label);
   /**filterVertices func. filters vertices and manipulates.
    * @param key is key
    * @param filter is value of hashmap.
    * @return manipulated subgraph
    * */
  MyGraph filterVertices (String key, String filter);
/** Exports matrix.
    * @param return adj. Matrix version of graph
    * */
  int[][] exportMatrix();
/**printGraph func. Prints Graph.
    * */
  void printGraph();


  

}

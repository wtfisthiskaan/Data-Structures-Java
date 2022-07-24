import java.util.*;

public class MyGraph<E> implements DynamicGraph{
	//key is id value is list
	public Map<Vertex<E>, List<Vertex<E>>> adjList = new HashMap<>();

	public Map<Vertex<E>, List<Vertex<E>>> getAdjList(){
		return adjList;
	}
	/** Base constructor.
	*/
	public MyGraph(){
	}
	/** Constructor takes hashmap and creates graph with it. 
	* @param adjList creates Graph with adjlist.
	*/
	public MyGraph(Map<Vertex<E>, List<Vertex<E>>> adjList){
		this.adjList=adjList;
	}
	/** Create new vertex.
	* @param label is label of vertex
	* @param weight is weight of vertex.
	* @return Created vertex.
	*/
	@Override
	public Vertex<E> newVertex (String label, double weight){
		Vertex<E> ver=new Vertex<E>(label,weight);
		return ver;
	}
	/** Adds vertex.
	 * @param new_vertex is vertex to be added.
	 * */
	@Override
	public void addVertex (Vertex new_vertex){
		List<Vertex<E>> temp = new ArrayList<>();
		new_vertex.index=adjList.size();
		adjList.put(new_vertex,temp);
	}
	/** Adds edge
	 * @param vertexID1 is reference of vertex.
	 * @param vertexID2 is reference of vertex.
	 * @param weight is weight of connection.
	 * 
	 * */
	@Override
	public void addEdge (int vertexID1, int vertexID2, double weight){
		Vertex<E> from=new Vertex<E>();
		Vertex<E> to=new Vertex<E>();
		for (Vertex<E> e : adjList.keySet()) {
			if(e.index==vertexID1){
				from=e;
			}
			if(e.index==vertexID2){
				to=e;
			}
        }

        if(from==null || to==null)
        	return;

        to.weight=weight;

        adjList.get(from).add(to);
	}

		/** Removes edge
	 * @param vertexID1 is reference of vertex.
	 * @param vertexID2 is reference of vertex.
	 * */
	 @Override
	public void removeEdge (int vertexID1, int vertexID2){
		Vertex<E> from=new Vertex<E>();
		Vertex<E> to=new Vertex<E>();
		for (Vertex<E> e : adjList.keySet()) {
			if(e.index==vertexID1){
				from=e;
			}
			if(e.index==vertexID2){
				to=e;
			}
        }
        if(from==null || to==null)
        	return;
        adjList.get(from).remove(to);
	}

	/** Removes vertex
	 * @param vertexID is reference id of vertex
	 * */
	 @Override
	public void removeVertex (int vertexID){
		Vertex<E> deleted=new Vertex<E>();
		for (Vertex<E> e : adjList.keySet()) {
			if(e.index==vertexID){
				deleted=e;
				adjList.remove(e);
				break;
			}
        }

		for (Vertex<E> e : adjList.keySet()) {
			if(adjList.get(e).contains(deleted)){
				adjList.get(e).remove(deleted);
				break;
			}
        }

	}


	/** Removes vertex
	 * @param label is label of vertex
	 * */
	@Override
	public void removeVertex (String label){
		Vertex<E> deleted=new Vertex<E>();
		for (Vertex<E> e : adjList.keySet()) {
			if(e.label==label){
				deleted=e;
				adjList.remove(e);
				break;
			}
        }

		for (Vertex<E> e : adjList.keySet()) {
			if(adjList.get(e).contains(deleted)){
				adjList.get(e).remove(deleted);
				break;
			}
        }
        
	}
	/** Exports matrix.
	 * @param return adj. Matrix version of graph
	 * */
	@Override
	public int[][] exportMatrix(){
		int graphSize=adjList.size();
		int[][] matrix=new int[graphSize][graphSize];

		for(int i = 0 ;i < graphSize; i++){
			for(int j = 0;j < graphSize; j++){
				matrix[i][j]=0;
			}
		}

		for (Vertex<E> e : adjList.keySet()) { 
			List<Vertex<E>> temp = new ArrayList<>();
			temp=adjList.get(e);
			for(int i = 0 ; i < temp.size(); i++){
				matrix[e.index][temp.get(i).index]=1;
			}
        }

        return matrix;

	}
	/**printGraph func. Prints Graph.
	 * */
	@Override
	public void printGraph(){
		System.out.println(" S  D  Weight");
		for (Vertex<E> e : adjList.keySet()) { 
			List<Vertex<E>> temp = new ArrayList<>();
			temp=adjList.get(e);
			for(int i = 0 ; i < temp.size(); i++){
				System.out.println("[("+e.index+","+temp.get(i).index+"): "+ temp.get(i).weight+"]");
			}
        }
	}
	/**filterVertices func. filters vertices and manipulates.
	 * @param key is key
	 * @param filter is value of hashmap.
	 * @return manipulated subgraph
	 * */
	@Override
	public MyGraph filterVertices(String key, String filter){
		//MyGraph<E> temp=this;
		Map<Vertex<E>, List<Vertex<E>>> temp=adjList;
		for (Vertex<E> e : temp.keySet()) {
			e.replace(key,filter);
			List<Vertex<E>> tempList = temp.get(e);
			for(int i = 0;i < tempList.size(); i++){
				tempList.get(i).replace(key,filter);
			} 
		}
		return new MyGraph(temp);
	}
	  /** Return the number of vertices.
      @return The number of vertices
   */
	@Override
	public int getNumV(){return adjList.size();}
	/** Determine whether this is a directed graph.
      @return true if this is a directed graph
   */
	@Override
	public boolean isDirected(){
		for (Vertex<E> e : adjList.keySet()) {
			List<Vertex<E>> temp = adjList.get(e);
			if(temp.size()==0)
				return false;
			for(int j=0;j<temp.size();j++){
				if(!adjList.get(temp.get(j)).contains(e))
					return false;
			}
        }
        return true;
	}
	/** Determine whether an edge exists.
      @param source The source vertex
      @param dest The destination vertex
      @return true if there is an edge from source to dest
   */
	@Override
	public boolean isEdge(int source, int dest){
		for (Vertex<E> e : adjList.keySet()) {
			if(e.index == source){
				if(adjList.get(e).contains(adjList.get(dest)))
					return true;
				else
					return false;
			}
        }
        return false;
	}
	/** Prints properties of vertices.
   */
	public void showProperties(){
		for (Vertex<E> e : adjList.keySet()) {
			e.printInfoMap();
        }
	}


	public int BFS(int s)
    {
    	int sum=0;
		//Map<Vertex<Integer>, List<Vertex<Integer>>> adjList=m.getAdjList();
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[adjList.size()];
 
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);
 		

       /* for (Vertex<E> e : adjList.keySet()) { 
			List<Vertex<E>> temp = new ArrayList<>();
			temp=adjList.get(e);
			for(int i = 0 ; i < temp.size(); i++){
				System.out.println("[("+e.index+","+temp.get(i).index+"): "+ temp.get(i).weight+"]");
			}
        }*/


        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");
 			for (Vertex<E> e : adjList.keySet()) {

				if(e.index==s){
					int k=0;
		            while (k<adjList.get(e).size())
		            {
		                int n = adjList.get(e).get(k).index;
		                if (!visited[n])
		                {
		                	sum+=adjList.get(e).get(k).weight;
		                    visited[n] = true;
		                    queue.add(n);
		                }
		                k++;
		            }
					break;
				}
        		}
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            //Iterator<Vertex<Integer>> i = adjList.get(s).iterator();
            //adjList.get(s).get(0);
            //System.out.println(adjList.get(s).get(0)+"11");
            //List<Vertex<E>> i = adjList.get(s);
            /*if(adjList.get(e)==null){
            	System.out.println("baa");
            }*/
          
        }
        System.out.print("   ||   ");
        return sum;
    }


    // A function used by DFS
    public int DFSUtil(int v, boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");
 		
        // Recur for all the vertices adjacent to this
        // vertex
        for (Vertex<E> e : adjList.keySet()){
        	int k=0;
        	while(k<adjList.get(e).size()){
        		int n = adjList.get(e).get(k).index;
        		if (!visited[n])
                	return (int)adjList.get(e).get(k).weight + DFSUtil(n, visited);
                k++;
        	}
        }
        System.out.print("   ||   ");
        return 0;
    }
 
    // The function to do DFS traversal.
    // It uses recursive
    // DFSUtil()
    public int DFS(int v)
    {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[adjList.size()];
 
        // Call the recursive helper
        // function to print DFS
        // traversal
        return DFSUtil(v, visited);
    }



}
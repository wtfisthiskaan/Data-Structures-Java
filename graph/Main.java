import java.util.*;

public class Main{

	public static int BFS_DFS_Difference(MyGraph gr){
		System.out.println("\n\n\n\n");
		System.out.println("BFS Search      Path");
		int bfs=gr.BFS(0);
		System.out.print(bfs);
		System.out.println("\n\n\n\n");
		System.out.println("DFS Search      Path");
		int dfs=gr.DFS(0);
		System.out.print(dfs);
		System.out.println("\n\n\n\n");
		return bfs-dfs;
	}


	public static void main(String[] arg){
		MyGraph<Integer> gr=new MyGraph<Integer>();
		Vertex<Integer> a1=gr.newVertex("a1",0);
		Vertex<Integer> a2=gr.newVertex("a2",0);
		Vertex<Integer> a3=gr.newVertex("a3",0);
		Vertex<Integer> a4=gr.newVertex("a4",0);

		a1.addInfo("length","5");
		a2.addInfo("length","5");
		a3.addInfo("length","5");
		a4.addInfo("length","5");

		gr.addVertex(a1);
		gr.addVertex(a2);
		gr.addVertex(a3);
		gr.addVertex(a4);

		gr.addEdge(0,1,20);
		gr.addEdge(1,2,10);
		gr.addEdge(2,3,30);
		gr.addEdge(3,0,5);
		gr.addEdge(3,2,5);
		gr.addEdge(3,1,12);
		System.out.println("\n");
		System.out.println("PRINT GRAPH WITH METHOD\n\n");
		System.out.println("\nNumber of Vertices: "+gr.getNumV()+"\n");
		gr.printGraph();
		System.out.println("\n");
		System.out.println("PRINT PROPERTIES OF VERTICES\n\n");
		gr.showProperties();
		System.out.println("\n");
		System.out.println("MATRIX VERSION OF GRAPH\n\n");
		int[][] matrix=gr.exportMatrix();
		for(int i = 0 ;i < matrix.length; i++){
			for(int j = 0;j < matrix.length; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("\n Difference : "+BFS_DFS_Difference(gr)+"\n");
		gr.removeEdge(3,1);
		System.out.println("\n");
		System.out.println("AFTER EDGE 3 -> 1 REMOVED\n\n");
		System.out.println("\nNumber of Vertices: "+gr.getNumV()+"\n");
		gr.printGraph();
		System.out.println("\n");
		System.out.println("MATRIX VERSION OF THE GRAPH\n\n");
		matrix=gr.exportMatrix();
		for(int i = 0 ;i < matrix.length; i++){
			for(int j = 0;j < matrix.length; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}

		
		gr.removeVertex(3);
		System.out.println("\n");
		System.out.println("AFTER VERTEX 3 IS REMOVED\n\n");
		System.out.println("\nNumber of Vertices: "+gr.getNumV()+"\n");
		gr.printGraph();
		System.out.println("\n");
		System.out.println("MATRIX VERSION OF THE GRAPH\n\n");
		matrix=gr.exportMatrix();
		for(int i = 0 ;i < matrix.length; i++){
			for(int j = 0;j < matrix.length; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("\n");
		System.out.println("LENGTH PROPERTY CHANGED 5 -> 7\n\n");

		MyGraph<Integer> gr2=gr.filterVertices("length","7");
		gr2.printGraph();
		System.out.println("\n");
		System.out.println("PRINT PROPERTIES OF VERTICES\n\n");
		gr2.showProperties();

	}
}
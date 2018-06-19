package com.hemant.datastructures.graph;

import com.hemant.algorithms.graph.DFS;
import com.hemant.algorithms.graph.DFSIterative;

public class Test {
	public static void main(String[] args) {
		Graph graph = new Graph(12);
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(4, 1);
		graph.addEdge(1, 3);
		graph.addEdge(3, 5);
		graph.addEdge(7, 8);
		graph.addEdge(8, 10);
		graph.addEdge(10, 9);
		graph.addEdge(10, 11);
		graph.addEdge(10, 12);
		graph.addEdge(9, 7);
		graph.addEdge(11, 12);
		
		DFS algo = new DFSIterative(graph);
		boolean[] visited = algo.execute(1);
		System.out.println(algo.isGraphConnected(visited));
		for (int i=1; i < visited.length; i++) {
			System.out.printf("Vertex %s : %s", i, visited[i]);
			System.out.println();
		}
		System.out.println(algo.getVertexComponentCount(1));
		int[] vertexComponent = algo.findVertexComponents();
		for (int i=1; i < vertexComponent.length; i++) {
			System.out.printf("Vertex : %s :::: Component: %s", i, vertexComponent[i]);
			System.out.println();
		}
	}
}

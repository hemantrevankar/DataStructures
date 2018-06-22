package com.hemant.algorithms.graph;

import com.hemant.datastructures.graph.Graph;

public class DFSRecursive extends DFS {
	public DFSRecursive(Graph graph) {
		super(graph);
	}

	@Override
	public boolean[] execute(int startVertex) {
		System.out.println("From Recursive DFS");
		boolean[] visited = new boolean[graph.getNumberOfVertices() + 1];
		DFSUtil(startVertex, visited, -1);
		return visited;
	}

	// modified method signature to pass in the parent vertex to determine if the graph contains a cycle.
	public void DFSUtil(int startVertex, boolean[] visited, int parentVertex) {
		visited[startVertex] = true;
		for (int adjacentVertex : graph.getAdjacentVertices(startVertex)) {
			if (visited[adjacentVertex] != true) {
				DFSUtil(adjacentVertex, visited, startVertex);
			} else if (adjacentVertex != parentVertex) {
				isCyclic = true;
			}
		}
	}
}

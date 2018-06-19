package com.hemant.algorithms.graph;

import com.hemant.datastructures.graph.Graph;

public class DFSRecursive extends DFS{
	public DFSRecursive(Graph graph) {
		super(graph);
	}

	@Override
	public boolean[] execute(int startVertex) {
		System.out.println("From Recursive DFS");
		boolean [] visited = new boolean[graph.getNumberOfVertices() + 1];
		DFSUtil(startVertex, visited);
		return visited;
	}
	
	public void DFSUtil(int startVertex, boolean[] visited) {
		if (visited[startVertex] != true) {
			visited[startVertex] = true;
			for (int adjacentVertex : graph.getAdjacentVertices(startVertex)) {
				DFSUtil(adjacentVertex, visited);
			}
		}
	}

}

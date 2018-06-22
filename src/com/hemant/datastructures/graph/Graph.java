package com.hemant.datastructures.graph;

import java.util.LinkedList;
import java.util.List;

public class Graph {
	private int vertices;
	private LinkedList<Integer> [] adjacencyList;
	
	public Graph(int vertices) {
		this.vertices = vertices;
		adjacencyList = new LinkedList[vertices+1];
		for (int i=1; i<=this.vertices; i++) {
			adjacencyList[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int fromVertex, int toVertex) {
		this.adjacencyList[fromVertex].add(toVertex);
		this.adjacencyList[toVertex].add(fromVertex);
	}

	public int getNumberOfVertices() {
		return this.vertices;
	}
	
	public List<Integer> getAdjacentVertices(int vertex) {
		return adjacencyList[vertex];
	}
}

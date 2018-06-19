package com.hemant.algorithms.graph;

import java.util.Stack;

import com.hemant.datastructures.graph.Graph;

public class DFSIterative extends DFS{
	Stack<Integer> stack;
	public DFSIterative(Graph graph) {
		super(graph);
		stack = new Stack<>();
	}

	@Override
	public boolean[] execute(int startVertex) {
		System.out.println("From Iterative DFS");
		boolean [] visited = new boolean[graph.getNumberOfVertices() + 1];

		stack.push(startVertex);
		while (!stack.isEmpty()) {
			int vertex = stack.pop();
			if (visited[vertex] == false) visited[vertex] = true;
			for (int adjacentVertex : graph.getAdjacentVertices(vertex)) {
				if (!visited[adjacentVertex]) {
					stack.push(adjacentVertex);
				}
			}
		}
		return visited;
	}
	
}

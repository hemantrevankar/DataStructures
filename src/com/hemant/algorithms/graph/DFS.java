package com.hemant.algorithms.graph;

import java.util.function.Consumer;

import com.hemant.datastructures.graph.Graph;

public abstract class DFS {
	protected Graph graph;
	private boolean gvisited[];
	protected int vertexComponent[];
	protected boolean isCyclic;

	public DFS(Graph graph) {
		this.graph = graph;
		this.gvisited = new boolean[graph.getNumberOfVertices() + 1];
		this.vertexComponent = new int[graph.getNumberOfVertices() + 1];
	}
	
	public Graph getGraph() {
		return this.graph;
	}
	
	public abstract boolean[] execute(int startVertex);
	
	public boolean isGraphConnected(boolean[] visited) {
		for (boolean vertex : visited) {
			if (!vertex) {
				return false;
			}
		}
		return true;
	}
	
	public int getVertexComponentCount(int startVertex) {
		int count = 1;		
		markVerticesWithComponentNumber(count, execute(startVertex));
		for (int i=1; i<gvisited.length; i++) {
			if (gvisited[i] == false) {
				markVerticesWithComponentNumber(++count, execute(i));
			} 
		}
		return count;
	}
	
	public int[] findVertexComponents(int s, Consumer<Integer> consumer) {
		consumer.accept(s);
		return this.vertexComponent;
	}
	
	public Consumer<Integer> findDistinctComponents() {
		return (s) -> {
			int count = 1;		
			markVerticesWithComponentNumber(count, execute(s));
			for (int i=1; i<gvisited.length; i++) {
				if (gvisited[i] == false) {
					markVerticesWithComponentNumber(++count, execute(i));
				} 
			}
		};
	}

	public void markVerticesWithComponentNumber(int count, boolean[] visited) {
		for (int i=1; i<visited.length; i++) {
			if (visited[i] == true) {
				vertexComponent[i] = count;
			} 
		}
		syncVisitedArray(visited);
	}
	
	private void syncVisitedArray(boolean[] current) {
		for (int i=1; i<gvisited.length; i++) {
			if (current[i] == true) {
				gvisited[i] = true;
			}
		}
	}
	
	public boolean isGraphCyclic() {
		return this.isCyclic;
	}
}

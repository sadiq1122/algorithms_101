package com.example.algo101.ds.graphs;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public List<List<Integer>> getGraph(int V) {

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            adjList.add(new ArrayList<>());
        }
        AdjacencyList.addEdge(adjList, 0, 1);
        AdjacencyList.addEdge(adjList, 0, 2);
        AdjacencyList.addEdge(adjList, 1, 3);
        AdjacencyList.addEdge(adjList, 1, 4);
        AdjacencyList.addEdge(adjList, 2, 5);
        AdjacencyList.addEdge(adjList, 2, 6);
        AdjacencyList.addEdge(adjList, 6, 7);

        return adjList;
    }

    public void dfs(int node, List<List<Integer>> graph, boolean[] visited, List<Integer> path) {
        visited[node] = true;
        path.add(node);

        for (int child : graph.get(node)) {
            if (!visited[child]) {
                dfs(child, graph, visited, path);
            }
        }
    }

    public static void main(String[] args) {

        DFS runner = new DFS();
        int V = 8;
        List<List<Integer>> graph = runner.getGraph(V);
        boolean[] visited = new boolean[V];
        List<Integer> res = new ArrayList<>();
        runner.dfs(2, graph, visited, res);
        System.out.println(res);
    }
}

package com.example.algo101.ds.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {


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

    public void bfs(List<List<Integer>> graph, int V) {
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            list.add(node);
            // enqueue the neighbours of the node
            for (int child : graph.get(node)) {
                if (!visited[child]) {
                    queue.add(child);
                    visited[child] = true;
                }
            }
        }

        // printing the bfs traversal
        System.out.println(list);
    }

    public static void main(String[] args) {

        BFS runner = new BFS();
        int V = 8;
        List<List<Integer>> graph = runner.getGraph(V);
        runner.bfs(graph, V);
    }
}

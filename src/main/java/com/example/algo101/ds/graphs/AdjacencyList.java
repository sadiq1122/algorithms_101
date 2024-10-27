package com.example.algo101.ds.graphs;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {

    public static void addEdge(List<List<Integer>> list, int v1, int v2) {
        list.get(v1).add(v2);
        list.get(v2).add(v1);
    }


    public static void printAdjacencyList(List<List<Integer>> adjList) {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + " : ");
            for (int v : adjList.get(i)) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adjList.add(new ArrayList<>());
        }

        addEdge(adjList, 0, 1);
        addEdge(adjList, 0, 2);
        addEdge(adjList, 0, 3);
        addEdge(adjList, 1, 3);
        printAdjacencyList(adjList);
    }
}

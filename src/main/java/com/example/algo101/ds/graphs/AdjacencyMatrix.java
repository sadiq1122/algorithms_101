package com.example.algo101.ds.graphs;


public class AdjacencyMatrix {

    public static void addEdge(int[][] adjMatrix, int v1, int v2) {
        adjMatrix[v1][v2] = 1;
        adjMatrix[v2][v1] = 1;
    }

    private static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int v : mat[i]) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] mat = new int[V][V];

        addEdge(mat, 0, 1);
        addEdge(mat, 0, 2);
        addEdge(mat, 0, 3);
        addEdge(mat, 1, 3);

        printMatrix(mat);

    }
}

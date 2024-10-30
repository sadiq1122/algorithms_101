package com.example.algo101.ds.graphs;


record Pair(int first, int second) {
}

public class NoOfIslands {


    public static void dfs(int row, int col, int[][] visited, char[][] grid) {
        visited[row][col] = 1;

        for (int delRow = -1; delRow <= 1; delRow++) {
            for (int delCol = -1; delCol <= 1; delCol++) {
                int childRow = row + delRow;
                int childCol = col + delCol;
                if (childRow >= 0 && childRow < grid.length && childCol >= 0 && childCol < grid[0].length && grid[childRow][childCol] == '1' && visited[childRow][childCol] == 0) {
                    dfs(childRow, childCol, visited, grid);
                }
            }
        }

    }

    public static int getNoOfIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && vis[i][j] == 0) {
                    dfs(i, j, vis, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '0', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '0', '1'}
        };

        int noOfIslands = getNoOfIslands(grid);
        System.out.println(noOfIslands);

    }

}


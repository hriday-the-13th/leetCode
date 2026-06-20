class Solution {
    public record Pair(int row, int col){}
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];

        int islandCount = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1' && vis[i][j] != 1){
                    bfs(i, j, grid, vis, m, n);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }
    public void bfs(int row, int col, char[][] grid, int[][] vis, int m, int n){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        vis[row][col] = 1;
        int[] drow = {0, 1, 0, -1};
        int[] dcol = {1, 0, -1, 0};
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int r = pair.row();
            int c = pair.col();
            for(int i=0; i<4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>=0 && ncol>=0 && nrow<m && ncol<n &&
                grid[nrow][ncol] == '1' && vis[nrow][ncol] != 1){
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }
    }
}
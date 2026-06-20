class Solution {
    public record Pair(int row, int col){}
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        int vis[][] = new int[m][n];

        for(int i=0; i<m; i++){
            if(grid[i][0] == 1){
                queue.add(new Pair(i, 0));
                vis[i][0] = 1;
            }

            if(grid[i][n-1] == 1){
                queue.add(new Pair(i, n-1));
                vis[i][n-1] = 1;
            }
        }

        for(int j=0; j<n; j++){
            if(grid[0][j] == 1){
                queue.add(new Pair(0, j));
                vis[0][j] = 1;
            }

            if(grid[m-1][j] == 1){
                queue.add(new Pair(m-1, j));
                vis[m-1][j] = 1;
            }
        }

        bfs(grid, queue, vis, m, n);
        int enclaveCount = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && vis[i][j] != 1){
                    enclaveCount++;
                }
            }
        }

        return enclaveCount;
    }

    public void bfs(int[][] grid, Queue<Pair> queue, int[][] vis, int m, int n){
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int row = pair.row();
            int col = pair.col();

            for(int i=0; i<4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow>=0 && ncol>=0 && ncol<n && nrow<m &&
                grid[nrow][ncol] == 1 && vis[nrow][ncol] != 1){
                    queue.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }
    }
}
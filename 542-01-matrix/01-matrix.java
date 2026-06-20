class Solution {
    public record Pair(int row, int col){}
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int[][] vis = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    vis[i][j] = 1;
                    queue.add(new Pair(i, j));
                }
            }
        }

        bfs(mat, queue, vis, m, n);

        return mat;
    }

    public void bfs(int[][] mat, Queue<Pair> queue, int[][] vis, int m, int n){
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int row = pair.row();
            int col = pair.col();

            for(int i=0; i<4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow >= 0 && ncol >= 0 && nrow < m && ncol < n &&
                vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    mat[nrow][ncol] = mat[row][col] + 1;
                    queue.add(new Pair(nrow, ncol));
                }

            }
            
        }
    }
}
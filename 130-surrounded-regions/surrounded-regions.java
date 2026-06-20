class Solution {
    public record Pair(int row, int col){}
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] vis = new int[m][n];
        Queue<Pair> queue = new LinkedList<>();

        //travel first and last row and first and last column and add them to queue for traversal
        for(int j=0; j<n; j++){
            if(board[0][j] == 'O'){
                queue.add(new Pair(0, j));
                vis[0][j] = 1;
            }

            if(board[m-1][j] == 'O'){
                queue.add(new Pair(m-1, j));
                vis[m-1][j] = 1;

            }
        }

        for(int i=0; i<m; i++){
            if(board[i][0] == 'O'){
                queue.add(new Pair(i, 0));
                vis[i][0] = 1;
            }

            if(board[i][n-1] == 'O'){
                queue.add(new Pair(i, n-1));
                vis[i][n-1] = 1;

            }
        }


        bfs(board, queue, vis, m, n);

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O' && vis[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void bfs(char[][] board, Queue<Pair> queue, int[][] vis, int m, int n){
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int row = pair.row();
            int col = pair.col();

            for(int i=0; i<4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow>=0 && ncol>=0 && nrow<m && ncol<n &&
                board[nrow][ncol] == 'O' && vis[nrow][ncol] == 0){
                    queue.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }
    }
}
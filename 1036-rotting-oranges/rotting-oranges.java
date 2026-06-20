class Solution {

    static class Pair{
        private int row;
        private int col;
        private int time;
        public Pair(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }

        public int getRow(){
            return this.row;
        }

        public int getCol(){
            return this.col;
        }

        public int getTime(){
            return this.time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshCount = 0;
        Queue<Pair> queue = new LinkedList<>();
        int[][] vis = new int[m][n];
        for (int[] row : vis) {
            Arrays.fill(row, 0);
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } 

                if (grid[i][j] == 1) freshCount++;
            }
        }


        int maxTime = 0;
        int[] drow = {1, 0, -1, 0};
        int[] dcol = {0, 1, 0, -1};
        int count = 0;
        
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int row = pair.getRow();
            int col = pair.getCol();
            int time = pair.getTime();

            maxTime = Math.max(maxTime, time);

            for(int i=0; i<4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow >= 0 && ncol >= 0 && nrow < m && ncol < n &&
                vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    queue.add(new Pair(nrow, ncol, time + 1));
                    vis[nrow][ncol] = 2;
                    count++;
                }
            }

        }


        if (count != freshCount) return -1;
        else return maxTime;

        




    }
    // public void bfs(int row, int col, int time, int[][] grid, int m, int n, int[][] vis){
        

    //     return maxTime;
    // }
}
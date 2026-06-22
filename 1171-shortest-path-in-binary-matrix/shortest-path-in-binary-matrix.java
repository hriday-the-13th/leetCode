class Solution {
    public record Triplet(int distance, int row, int col){}
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        int m = grid.length;
        int n = grid[0].length;

        int[][] distance = new int[m][n];

        for(int[] row: distance) {
            Arrays.fill(row, (int) 1e9);
        }
        
        distance[0][0] = 1;

        Queue<Triplet> pq = new LinkedList<>();
        pq.add(new Triplet(1, 0, 0));



        int[] drow = {0, 1, 0, -1, 1, 1, -1, -1};
        int[] dcol = {1, 0, -1, 0, 1, -1, -1, 1};
        
        while(!pq.isEmpty()){
            Triplet triplet = pq.poll();
            int dist = triplet.distance();
            int row = triplet.row();
            int col = triplet.col();

            for(int i=0; i<8; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow>=0 && ncol>=0 && nrow<m && ncol<n &&
                grid[nrow][ncol] == 0 && dist + 1 < distance[nrow][ncol]){
                    distance[nrow][ncol] = dist + 1;
                    pq.add(new Triplet(distance[nrow][ncol], nrow, ncol));
                }

            }

        }

        if(distance[m-1][n-1] != (int) 1e9){
            return distance[m-1][n-1];
        } else return -1;


    }
}
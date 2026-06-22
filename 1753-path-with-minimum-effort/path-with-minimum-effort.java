class Solution {
    public record Tuple(int effort, int row, int col){}
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x, y) -> Integer.compare(x.effort, y.effort));

        int[][] efforts = new int[m][n];

        for(int[] row: efforts){
            Arrays.fill(row, (int) 1e9);
        }

        efforts[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));

        int[] drow = {0, 1, 0, -1};
        int[] dcol = {1, 0, -1, 0};
        while(!pq.isEmpty()){
            Tuple tuple = pq.poll();
            int effort = tuple.effort();
            int row = tuple.row();
            int col = tuple.col();

            for(int i=0; i<4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                
                // int diff = Math.abs(heights[nrow][ncol] - heights[row][col]); 

                if(nrow>=0 && ncol>=0 && nrow<m && ncol<n){
                    int diff = Math.max(effort, Math.abs(heights[nrow][ncol] - heights[row][col]));
                    if (diff < efforts[nrow][ncol]){
                        efforts[nrow][ncol] = diff;
                        pq.add(new Tuple(efforts[nrow][ncol], nrow, ncol));
                    }
                }
            }
        }

        return efforts[m-1][n-1];
    }
}
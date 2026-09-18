class Solution {
    public record Triplet(int row, int col, int color){}
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int[][] visited = new int[n][m];

        for(int i=0; i<n; i++){
            Arrays.fill(visited[i], 0);
        }

        Triplet src = new Triplet(sr, sc, image[sr][sc]);

        bfs(image, src, color, visited);

        return image;
    }

    public void bfs(int[][] image, Triplet triplet, int color, int[][] visited){
        int n = image.length;
        int m = image[0].length;
        Queue<Triplet> queue = new LinkedList<>();
        queue.add(triplet);
        visited[triplet.row][triplet.col] = 1;
        image[triplet.row][triplet.col] = color;
        int[] drow = {1, 0, -1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!queue.isEmpty()){
            Triplet curr = queue.poll();
            int row = curr.row;
            int col = curr.col;
            int prevColor = curr.color;
            for(int i=0; i<4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == prevColor && visited[nrow][ncol] != 1){
                    image[nrow][ncol] = color;
                    queue.add(new Triplet(nrow, ncol, prevColor));
                    visited[nrow][ncol] = 1;
                }
            }
        }
    }
}
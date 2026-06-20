class Solution {
    public record Pair(int key, int value) {}
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        // int[][] visited = new int[m][n];
        // for(int[] row: visited){
        //     Arrays.fill(row, 0);
        // }
        int originalColor = image[sr][sc];

        if (originalColor == color) return image;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));
        image[sr][sc] = color;
        // visited[sr][sc] = 1;


        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int row = pair.key();
            int col = pair.value();

            for(int i=0; i<4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow >= 0 && ncol >= 0 && nrow < m && ncol < n &&
                /*visited[nrow][ncol] == 0 &&*/ image[nrow][ncol] == originalColor) {
                    queue.add(new Pair(nrow, ncol));
                    image[nrow][ncol] = color;
                    // visited[nrow][ncol] = 1;
                }

            }
        }

        return image;
        
    }
}
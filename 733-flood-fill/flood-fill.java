class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int originalColor = image[sr][sc];

        // Prevent revisiting forever when color doesn't change
        if (originalColor == color) {
            return image;
        }

        int[] drow = {1, 0, -1, 0};
        int[] dcol = {0, 1, 0, -1};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc});

        image[sr][sc] = color;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = row + drow[i];
                int nc = col + dcol[i];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    image[nr][nc] == originalColor) {

                    // Mark visited immediately
                    image[nr][nc] = color;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return image;
    }
}
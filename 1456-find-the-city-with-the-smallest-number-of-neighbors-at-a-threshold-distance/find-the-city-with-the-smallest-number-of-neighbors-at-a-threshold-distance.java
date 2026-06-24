class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int[][] adjMatrix = new int[n][n];

        for(int[] matrix: adjMatrix){
            Arrays.fill(matrix, (int)1e9);
        }

        for(int i=0; i<n; i++){
            adjMatrix[i][i] = 0;
        }


        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adjMatrix[u][v] = w;
            adjMatrix[v][u] = w;
        }

        for(int via=0; via<adjMatrix.length; via++){
            for(int i=0; i<adjMatrix.length; i++){
                for(int j=0; j<adjMatrix.length; j++){
                    if(adjMatrix[i][via] != (int) 1e9 && adjMatrix[via][j] != (int) 1e9){
                        adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][via] + adjMatrix[via][j]);
                    }
                }
            }
        }

        int count = Integer.MAX_VALUE;
        int city = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            int curr = 0;
                for(int j=0; j<n; j++){
                    if(adjMatrix[i][j] <= distanceThreshold){
                        curr++;
                    }
                }
            if(curr <= count){
                count = curr;
                if(i > city){
                    city = i;
                }
            }
        }

        return city;
    }
}
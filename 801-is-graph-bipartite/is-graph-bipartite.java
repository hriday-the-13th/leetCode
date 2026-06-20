class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        for(int i=0; i<graph.length; i++){
            if(color[i] == -1){
                if(!dfs(i, 0, graph, color)){
                    return false;
                };
            }
        }
        return true;
    }

    public boolean dfs(int node, int col, int[][] graph, int[] color){
        color[node] = col;
        for(int neighbour: graph[node]){
            if(color[neighbour] == -1){
                if(!dfs(neighbour, 1-col, graph, color)){
                    return false;
                }
            } else if(color[neighbour] == col){
                return false;
            }
        }
        return true;
    }
}
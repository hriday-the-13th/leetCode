class Solution {
    public int findCircleNum(int[][] isConnected) {
        int vertices = isConnected.length;
        int count = 0;
        
        boolean[] visited = new boolean[vertices];

        for(int i=0; i<vertices; i++){
            if(!visited[i]){
                count++;
                dfs(i, isConnected, vertices, visited);
            }
        }
        return count;

    }

    public void bfs(int startNode, int[][] isConnected, int v, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;
        
        while(!queue.isEmpty()){
            int curr = queue.poll();

            for(int i=0; i<v; i++){
                if(isConnected[curr][i] == 1 && !visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }

        }

    }

    public void dfs(int startNode, int[][] isConnected, int v, boolean[] visited){
        visited[startNode] = true;
        for(int i=0; i<v; i++){
            if(isConnected[startNode][i] == 1 && !visited[i]){
                dfs(i, isConnected, v, visited);
            }
        }
    }

}
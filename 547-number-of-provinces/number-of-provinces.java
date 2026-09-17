class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] isVisited = new boolean[isConnected.length];
        int count = 0;
        for(int i=0; i<isConnected.length; i++){
            if(!isVisited[i]){
                count++;
                bfs(isConnected, i, isVisited);
            }
        }
        return count;
    }
    public void bfs(int[][] isConnected, int i, boolean[] isVisited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        isVisited[i] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int j=0; j<isConnected[node].length; j++){
                if(isConnected[node][j] == 1 && !isVisited[j]){
                    queue.add(j);
                    isVisited[j] = true;
                }
            }
        }
    }
}
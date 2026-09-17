class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<isConnected.length; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<isConnected.length; i++){
            for(int j=0; j<isConnected[i].length; j++){
                if(isConnected[i][j] == 1){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        boolean[] isVisited = new boolean[isConnected.length];
        int count = 0;
        for(int i=0; i<isConnected.length; i++){
            if(!isVisited[i]){
                count++;
                bfs(adjList, i, isVisited);
            }
        }
        return count;
    }
    public void bfs(List<List<Integer>> adjList, int i, boolean[] isVisited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        isVisited[i] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int next: adjList.get(node)){
                if(!isVisited[next]){
                    queue.add(next);
                    isVisited[next] = true;
                }
            }
        }
    }
}
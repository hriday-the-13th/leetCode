class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // List<List<Integer>> adjList = new ArrayList<>();
        // for(int i=0; i<graph.length; i++){
        //     adjList.add(new ArrayList<>());
        // }

        // for(int[] edge: graph){
        //     int u = edge[0];
        //     int v = edge[1];

        //     adjList.get(u).add(v);
        // }

        boolean[] vis = new boolean[graph.length];
        boolean[] pathVis = new boolean[graph.length];
        boolean[] unSafe = new boolean[graph.length];


        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                if(dfs(i, graph, vis, pathVis, unSafe)){
                    unSafe[i] = true;
                }
            }
        }


        List<Integer> retList = new ArrayList<>();
        for(int i=0; i<unSafe.length; i++){
            if(!unSafe[i]){
                retList.add(i);
            }
        }

        return retList;

    }

    public boolean dfs(int node, int[][] graph, boolean[] vis, boolean[] pathVis, boolean[] unsafe){
        vis[node] = true;
        pathVis[node] = true;

        for(int neighbour: graph[node]){
            if(!vis[neighbour]){
                if(dfs(neighbour, graph, vis, pathVis, unsafe)){
                    unsafe[neighbour] = true;
                    return true;
                }
            } else if(pathVis[neighbour]){
                return true;
            }
        }
        pathVis[node] = false;
        return false;
    }
}
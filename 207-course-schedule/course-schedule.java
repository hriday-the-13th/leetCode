class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge: prerequisites){
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
        }


        for(int i=0; i<numCourses; i++){
            if(!vis[i]){
                if(dfs(i, adjList, vis, pathVis)){
                    return false;
                }
            }
        }

        return true;

    }

    public boolean dfs(int node, List<List<Integer>> adjList, boolean[] vis, boolean[] pathVis){
        vis[node] = true;
        pathVis[node] = true;

        for(int neighbour: adjList.get(node)){
            if(!vis[neighbour]){
                if(dfs(neighbour, adjList, vis, pathVis)){
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
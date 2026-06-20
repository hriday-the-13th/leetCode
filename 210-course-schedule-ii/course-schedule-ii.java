class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        for(int[] edge: prerequisites){
            int u = edge[0];
            int v = edge[1];

            adjList.get(v).add(u);
        }

        int truth = 0;
        for(int i = 0; i<numCourses; i++){
            if(!vis[i]){
                if(dfs(i, adjList, vis, pathVis, stack)){
                    return new int[0];
                }
            }
        }

        int arr[] = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            arr[i] = stack.pop();
        }
        return arr;

    }

    public boolean dfs(int node, List<List<Integer>> adjList, boolean[] visited, boolean[] pathVis, Stack<Integer> stack){
        visited[node] = true;
        pathVis[node] = true;
        for(int neighbour: adjList.get(node)){
            if(!visited[neighbour]){
                if(dfs(neighbour, adjList, visited, pathVis, stack)){
                    return true;
                }
            } else if(pathVis[neighbour]){
                return true;
            }
        }
        pathVis[node] = false;
        stack.push(node);
        return false;
    }
}
class Solution {
    public record Tuple(int stop, int node, int cost){}
    public record Edge(int node, int cost){}
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Edge>> adjList = new ArrayList<>();

        int[] costs = new int[n];

        Arrays.fill(costs, (int) 1e9);

        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : flights) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            adjList.get(u).add(new Edge(v, cost));
        }

        Queue<Tuple> pq = new LinkedList<>();

        pq.add(new Tuple(0, src, 0));
        costs[src] = 0;

        while(!pq.isEmpty()){
            Tuple tuple = pq.poll();
            int cost = tuple.cost();
            int stop = tuple.stop();
            int node = tuple.node();

            if (stop > k) continue;
            for(Edge neighbour: adjList.get(node)){
                int nNode = neighbour.node();
                int nCost = neighbour.cost();

                if(nCost + cost < costs[nNode] && stop <= k){
                    costs[nNode] = nCost + cost;
                    pq.add(new Tuple(stop + 1, nNode, costs[nNode]));
                }
            }
        }

        if(costs[dst] == (int) 1e9) return -1;
        return costs[dst];


    }
}
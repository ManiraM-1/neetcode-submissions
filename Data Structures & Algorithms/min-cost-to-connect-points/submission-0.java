class Solution {
    class Pair{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean visited[] = new boolean[n];
        int nodeCount = 0;
        int totalCost =0;
        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.add(new Pair(0,0));

        while(nodeCount<n){
            Pair curr = pq.poll();
            int nod = curr.node;
            int dis = curr.dist;

            if(visited[nod]) continue;
            visited[nod]=true;
            totalCost += dis;
            nodeCount++;

            for(int i=0;i<n; i++){
                if(!visited[i]){
                    int distance = Math.abs(points[nod][0]-points[i][0])+Math.abs(points[nod][1]-points[i][1]);
                    pq.add(new Pair(i,distance));
                }
            }
        }
        return totalCost;
    }
}

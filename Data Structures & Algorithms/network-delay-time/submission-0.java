class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        for(int[] arr: times){
            int u = arr[0];
            int v = arr[1];
            int w = arr[2];
            graph.get(u).add(new int[]{v,w});
        }

        int dist[] = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        dist[k]=0;
        pq.add(new int[]{0,k});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[1];
            int pw = curr[0];

            if(pw>dist[u]) continue;

            for(int[] nei: graph.get(u)){
                int v = nei[0];
                int cw = nei[1];

                if(dist[v]>pw+cw){
                    dist[v]=pw+cw;
                    pq.add(new int[]{dist[v],v});
                }
            }
        }
        int ans =0;
        for(int i=1; i<=n; i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}

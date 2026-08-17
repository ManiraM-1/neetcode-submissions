class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int[][] ans = new int[k][2];
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->(b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1]));
        for(int i=0; i<n; i++){
            pq.add(points[i]);
            while(pq.size()>k){
                pq.poll();
            }
        }
        int x=0;
        while(!pq.isEmpty()){
            ans[x++]=pq.poll();
        }
        return ans;

    }
}

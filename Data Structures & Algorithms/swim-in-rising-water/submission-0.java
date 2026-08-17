class Solution {
    class Pair{
        int element;
        int r,c;
        Pair(int element, int r, int c){
            this.element=element;
            this.r = r;
            this.c = c;
        }
    }
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.element-b.element);
        boolean visited[][]=new boolean[m][n];
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        pq.add(new Pair (grid[0][0],0,0));
        visited[0][0]=true;

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int i = p.r;
            int j = p.c;
            int ele = p.element;

            if(i==m-1 && j==n-1){
                return ele;
            }

            for(int k=0; k<4; k++){
                int nr = i+dx[k];
                int nc = j+dy[k];

                if(nr<0 || nc<0 || nr>=m || nc>=n || visited[nr][nc]==true) continue;
                visited[nr][nc]=true;
                pq.add(new Pair (Math.max(ele, grid[nr][nc]),nr,nc));
            }

            

        }
        return -1;
    
    }
}

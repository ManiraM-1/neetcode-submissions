class Solution {
    class Pair{
        int i,j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        int maxArea=0;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n;j++){
                if(grid[i][j]==1){
                    q.add(new Pair(i,j));
                    int area=0;
                    grid[i][j]=0;
                    while(!q.isEmpty()){
                        Pair p = q.poll();
                        int r = p.i;
                        int c = p.j;
                        area++;
                        for(int k=0; k<4; k++){
                            int nr = r+dx[k];
                            int nc = c+dy[k];
                            if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1){
                                q.add(new Pair(nr,nc));
                                grid[nr][nc]=0;
                            }
                        }
                    }
                    maxArea = Math.max(area,maxArea);
                }
            }
        }
        return maxArea;
    }
}

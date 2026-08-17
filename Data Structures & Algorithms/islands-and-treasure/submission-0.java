class Solution {
    class Pair{
        int i, j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        int inf = Integer.MAX_VALUE;
        Queue<Pair>zq=new LinkedList<>();
        Queue<Pair>iq=new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        for(int i=0; i<m; i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    zq.add(new Pair(i,j));
                }
            }
        }
        while(!zq.isEmpty()){
            Pair p = zq.poll();
            int r = p.i;
            int c = p.j;
            for(int k=0; k<4; k++){
                int nr = r+dx[k];
                int nc = c+dy[k];
                if(nr>=0 &&nr<m && nc>=0 && nc<n && grid[nr][nc]==inf){
                    grid[nr][nc]=grid[r][c]+1;
                    zq.add(new Pair(nr,nc));
                }
            }

        }
        
    }
}

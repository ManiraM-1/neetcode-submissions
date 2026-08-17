class Solution {
    class Pair{
        int i, j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dx[]={-1,0,1,0};
        int dy[] ={0,1,0,-1};
        Queue<Pair>q = new LinkedList<>();
        int islands = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    islands++;
                    q.add(new Pair(i,j));
                    grid[i][j]='0';

                    while(!q.isEmpty()){
                        Pair x = q.poll();
                        int r = x.i;
                        int c = x.j;
                        for(int k=0;k<4; k++){
                            int nr = r+dx[k];
                            int nc = c+dy[k];
                            if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]=='1'){
                                q.add(new Pair(nr,nc));
                                grid[nr][nc]='0';
                            }
                        }
                    }
                }
            }
        }
        
        
        return islands;
    }
}

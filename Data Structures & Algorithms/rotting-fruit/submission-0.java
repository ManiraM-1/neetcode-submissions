class Solution {
    class Pair{
        int i,j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair>q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh =0;
        for(int i=0; i<m; i++){
            for(int j=0;j<n; j++){
                if(grid[i][j]==1) fresh++;
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
            }
        }
        int time = 0;
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        while(!q.isEmpty()){
            int size=q.size();
            boolean rotted = false;
            for(int i=0; i<size; i++){
                Pair p = q.poll();
                int r = p.i;
                int c =p.j;
                for(int k=0; k<4; k++){
                    int nr = r+dx[k];
                    int nc = c+dy[k];
                    if(nr>=0&& nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        fresh--;
                        rotted=true;
                        q.add(new Pair(nr,nc));
                    }
                }
            }
            if(rotted) time++;
        }
        return fresh==0?time:-1;
    }
}

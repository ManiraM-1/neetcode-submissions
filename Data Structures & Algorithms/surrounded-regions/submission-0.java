class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        //traversing rows
        for(int i=0; i<m; i++){
            dfs(i,0,board);
            dfs(i,n-1,board);
        }
        for(int j=0; j<n; j++){
            dfs(0,j,board);
            dfs(m-1,j,board);
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O') board[i][j]='X';
                else if(board[i][j]=='#') board[i][j]='O';
            }
        }
    }

    void dfs(int r, int c, char[][] board){
        int m = board.length;
        int n = board[0].length;

        if(r<0 || c < 0 || r>=m || c >=n || board[r][c]!='O') return;

        board[r][c] = '#';
        int dx[] = {-1,0,1,0};
        int dy[] ={0,1,0,-1};

        for(int k=0;k<4; k++){
            int nr = r+dx[k];
            int nc = c+dy[k];
            
            dfs(nr,nc,board);
        }
    }
}
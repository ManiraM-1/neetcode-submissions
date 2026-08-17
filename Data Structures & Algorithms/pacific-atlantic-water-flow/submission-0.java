class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean [][] pacific = new boolean[m][n];
        boolean [][] atlantic = new boolean[m][n];

        for(int i=0; i<m; i++){
            dfs(i,0,pacific, heights);
            dfs(i,n-1, atlantic, heights);
        }
        for(int i=0; i<n; i++){
            dfs(0,i,pacific, heights);
            dfs(m-1,i,atlantic, heights);
        }

        List<List<Integer>> combined = new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    combined.add(Arrays.asList(i,j));
                }
            }
        }
        return combined;

    }

    private void dfs(int r, int c, boolean[][] matrix, int[][] heights){
        int m = heights.length;
        int n = heights[0].length;
        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};
        matrix[r][c]=true;

        for(int i=0; i<4; i++){
            int nr = r+dx[i];
            int nc = c+dy[i];

            if(nr<0 || nr >= m || nc<0 || nc >= n) continue;
            if (matrix[nr][nc]) continue;

            if(heights[r][c] <= heights[nr][nc]){
                dfs(nr,nc,matrix, heights);
            }
        }
    }
}
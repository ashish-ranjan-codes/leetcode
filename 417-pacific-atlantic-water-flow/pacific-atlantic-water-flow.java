class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        //Flood fill from pacific
        for(int i=0; i<m; i++) dfs(heights, pacific, i, 0);
        for(int j=0; j<n; j++) dfs(heights, pacific, 0, j);

        //Flood fill from atlantic
        for(int i=0; i<m; i++) dfs(heights, atlantic, i, n-1);
        for(int j=0; j<n; j++) dfs(heights, atlantic, m-1, j);

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int r, int c){
        int m = heights.length, n = heights[0].length;
        visited[r][c] = true;

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        for(int d=0; d<4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nc < 0 || nr >= m || nc >= n || visited[nr][nc]
            || heights[nr][nc] < heights[r][c]) continue;
            dfs(heights, visited, nr, nc);
        }
    }
}
class Solution {
    private static final int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        //Priority Queue
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int maxElevation = curr[0];
            int r = curr[1], c = curr[2];

            //if bottom right reached thn return answer
            if(r == n-1 && c == n-1) return maxElevation;

            for(int[] d : directions){
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr >=0 && nr < n && nc >=0 && nc < n && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    pq.offer(new int[]{Math.max(maxElevation, grid[nr][nc]), nr, nc});
                }
            }
        }
        return -1;    
    }
}
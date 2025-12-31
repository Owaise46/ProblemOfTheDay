class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1, right = cells.length;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canCross(row, col, cells, mid)) {
                ans = mid;          // possible, try later days
                left = mid + 1;
            } else {
                right = mid - 1;    // not possible, try earlier days
            }
        }
        return ans;
    }

    private boolean canCross(int row, int col, int[][] cells, int day) {
        boolean[][] water = new boolean[row][col];

        // flood cells up to "day"
        for (int i = 0; i < day; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            water[r][c] = true;
        }

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[row][col];

        // start from top row
        for (int c = 0; c < col; c++) {
            if (!water[0][c]) {
                q.offer(new int[]{0, c});
                vis[0][c] = true;
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if (r == row - 1) return true; // reached bottom

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < row && nc >= 0 && nc < col &&
                    !water[nr][nc] && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return false;
    }
}

class Solution {
    public int countNegatives(int[][] grid) {
        int rows=grid.length, cols=grid[0].length;
        int i=0, j=cols-1;
        int count=0;
        while(i<grid.length && j>=0){
            if(grid[i][j]<0){
                 count += (rows - i);
                j--;
            }
            else{
                i++;
            }
        }
        return count;
    }
}

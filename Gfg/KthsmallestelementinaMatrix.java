class Solution {
    public int healper(int[][] mat, int mid){
        int i=0, j=mat.length-1;
        int cnt=0;
        while(i<mat.length && j>=0){
            if(mat[i][j]<=mid){
                cnt +=(j+1);
                i++;
            }else{
                j--;
            }
        }
        return cnt;
    } 
    public int kthSmallest(int[][] mat, int k) {
        int n=mat.length;
        int l=mat[0][0];
        int h=mat[n-1][n-1];
        
        int ans=0;
        
        while(l<=h){
            int mid=(l+h)/2;
            
            int count=healper(mat, mid);
            
            if(count<k){
                l=mid+1;
            }else{
                ans=mid;
                h=mid-1;
            }
        }
        
        return ans;
    }
}


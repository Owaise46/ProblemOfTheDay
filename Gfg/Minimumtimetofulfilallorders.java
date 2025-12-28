class Solution {
    public int minTime(int[] ranks, int n) {
        int ans=Integer.MAX_VALUE;
        int low=0, high=Integer.MAX_VALUE;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            int cnt=0;
            for(int it:ranks) cnt+=countDonut(it, mid);
            if(cnt>=n){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    
    static long countDonut(int r, int t){
        long val= 1L+8L*t/r;
        long k=(long)((Math.sqrt(val)-1)/2);
       
       return k;
    }
}

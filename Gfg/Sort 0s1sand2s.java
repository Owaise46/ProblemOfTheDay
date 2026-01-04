class Solution {
    public void sort012(int[] arr) {
       int s=0,m=0,e=arr.length-1;
       while(m<=e){
           if(arr[m]==0){
               int temp=arr[s];
               arr[s]=arr[m];
               arr[m]=temp;
               s++;
               m++;
           }else if(arr[m]==2){
              
               int temp=arr[e];
               arr[e]=arr[m];
               arr[m]=temp;
               e--;
           }else{
               m++;
           }
       }
        
    }
}

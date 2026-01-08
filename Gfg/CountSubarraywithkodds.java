class Solution {
    
    public int countSubarrays(int[] arr, int k) {
        return atMost(arr, k) - atMost(arr, k - 1);
    }
    
    private int atMost(int[] arr, int k) {
        if (k < 0) return 0;
        
        int left = 0;
        int oddCount = 0;
        int result = 0;
        
        for (int right = 0; right < arr.length; right++) {
            if (arr[right] % 2 == 1) {
                oddCount++;
            }
            
            while (oddCount > k) {
                if (arr[left] % 2 == 1) {
                    oddCount--;
                }
                left++;
            }
            
            result += (right - left + 1);
        }
        
        return result;
    }
}

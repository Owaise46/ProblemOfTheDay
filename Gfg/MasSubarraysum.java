
class Solution {
    public int maximumSumSubarray(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return -1;

        int windowSum = 0;
        int maxSum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        // Slide the window
        for (int i = k; i < n; i++) {
            windowSum += arr[i];        // add next element
            windowSum -= arr[i - k];    // remove previous element
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}

class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        int n = arr.length;
        int xor = 0;

        // XOR of first window
        for (int i = 0; i < k; i++) {
            xor ^= arr[i];
        }

        int maxXor = xor;

        // Sliding window
        for (int i = k; i < n; i++) {
            xor ^= arr[i - k]; // remove left element
            xor ^= arr[i];     // add right element
            maxXor = Math.max(maxXor, xor);
        }

        return maxXor;
    }
}

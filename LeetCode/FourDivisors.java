class Solution {
    boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;

        for (int n : nums) {

            // Case 1: p^3
            int p = (int) Math.round(Math.cbrt(n));
            if (p * p * p == n && isPrime(p)) {
                totalSum += (1 + p + p * p + n);
                continue;
            }

           
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    int q = n / i;
                    if (i != q && isPrime(i) && isPrime(q)) {
                        totalSum += (1 + i + q + n);
                    }
                    break; 
                }
            }
        }
        return totalSum;
    }
}

class Solution {
    public int countSubstr(String s, int k) {
        if (k == 0) return 0;
        return atMostK(s, k) - atMostK(s, k - 1);
    }

    private int atMostK(String s, int k) {
        int[] freq = new int[26];
        int left = 0, distinct = 0, count = 0;

        for (int right = 0; right < s.length(); right++) {
            int r = s.charAt(right) - 'a';
            if (freq[r] == 0) distinct++;
            freq[r]++;

            while (distinct > k) {
                int l = s.charAt(left) - 'a';
                freq[l]--;
                if (freq[l] == 0) distinct--;
                left++;
            }

            count += right - left + 1;
        }
        return count;
    }
}

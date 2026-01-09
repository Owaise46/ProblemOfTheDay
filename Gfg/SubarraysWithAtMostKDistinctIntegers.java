class Solution {
    public int countAtMostK(int arr[], int k) {
        int left = 0;
        int n = arr.length;
        int ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            // add current element
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            // shrink window if distinct elements > k
            while (map.size() > k) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }

            // count subarrays ending at right
            ans += (right - left + 1);
        }

        return ans;
    }
}

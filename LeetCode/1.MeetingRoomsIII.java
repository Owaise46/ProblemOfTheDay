class Solution {
    public int mostBooked(int n, int[][] meetings) {

        int[] count = new int[n];

        // Min-heap of available rooms
        PriorityQueue<Integer> avail = new PriorityQueue<>();

        // Min-heap of busy rooms: [endTime, room]
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] 
                ? Long.compare(a[1], b[1]) 
                : Long.compare(a[0], b[0])
        );

        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Initially all rooms are free
        for (int i = 0; i < n; i++) {
            avail.offer(i);
        }

        for (int[] m : meetings) {
            long stime = m[0];
            long etime = m[1];
            long duration = etime - stime;

            // Free rooms that have completed meetings
            while (!busy.isEmpty() && busy.peek()[0] <= stime) {
                avail.offer((int) busy.poll()[1]);
            }

            long endtime;
            int room;

            if (!avail.isEmpty()) {
                room = avail.poll();
                endtime = stime + duration;
            } else {
                long[] top = busy.poll();
                room = (int) top[1];
                endtime = top[0] + duration;
            }

            busy.offer(new long[]{endtime, room});
            count[room]++;
        }

        // Find room with max meetings
        int max = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                max = count[i];
                ans = i;
            }
        }

        return ans;
    }
}

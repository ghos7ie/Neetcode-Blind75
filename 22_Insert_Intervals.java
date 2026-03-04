class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = 0;
        int length = intervals.length;
        List<int[]> results = new ArrayList<>();

        // for all existing intervals that end before the start of the new one
        while(start < length && intervals[start][1] < newInterval[0]) {
            results.add(intervals[start]);
            start++;
        }

        // for those that start before interval 1 ends
        while (start < length && newInterval[1] >= intervals[start][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[start][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[start][1]);
            start++;
        }
        results.add(newInterval);

        // now for those that end after 
        while (start < length) {
            results.add(intervals[start]);
            start++;
        }

        return results.toArray(new int[results.size()][]);
    }
}

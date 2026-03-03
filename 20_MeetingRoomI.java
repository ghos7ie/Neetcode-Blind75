/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int length = intervals.size();
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start)); // sort first
        for (int i = 0; i < length - 1; i++) {
            Interval first = intervals.get(i);
            Interval second = intervals.get(i+1);
            if (first.end > second.start) {
                return false;
            }
        }
        return true;
    }
}

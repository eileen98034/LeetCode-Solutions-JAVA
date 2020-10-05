/* #1288: Medium
Given a list of intervals, remove all intervals that are covered by another interval in the list.
Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.
After doing so, return the number of remaining intervals.
*/

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        // init
        int cnt = 1;
        
        // sort the matrix using a comparator
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] e1, int[] e2){
                if(e1[0] < e2[0]) return -1;
                if(e2[0] < e1[0]) return 1;
                if(e1[1] > e2[1]) return -1;
                return 1;
            }
        });
        
        // count how many intervals are not covered by another interval
        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= temp[0] && intervals[i][1] <= temp[1]) 
                continue;
            temp = intervals[i];
            cnt++;
        }
        
        // return
        return cnt;
    }
}

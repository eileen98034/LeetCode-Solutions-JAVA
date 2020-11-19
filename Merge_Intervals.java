/*
#56 : Medium
Given an array of intervals where intervals[i] = [starti, endi], 
merge all overlapping intervals, and return an array of the non-overlapping 
intervals that cover all the intervals in the input.
 */
 
class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> nonOverLapping = new ArrayList<>();
        Arrays.sort(intervals, (j,k) -> j[0]-k[0]);
        int first = Integer.MIN_VALUE, last = first;
        
        for (int[] i : intervals) {
            if (i[0] > last) {
                if (first > Integer.MIN_VALUE)
                    nonOverLapping.add(new int[] {first,last});
                first = i[0];
                last = i[1];
            } else {
                last = Math.max(last, i[1]);
            }
        }
                
        if (first > Integer.MIN_VALUE) 
            nonOverLapping.add(new int[] {first,last});

        return nonOverLapping.toArray(new int[][]{});
    }
}

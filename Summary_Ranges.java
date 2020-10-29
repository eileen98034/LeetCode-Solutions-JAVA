/*
#228 : Easy

You are given a sorted unique integer array nums.
Return the smallest sorted list of ranges that cover all the numbers in the array exactly. 
That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
*/

class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> ranges = new ArrayList<>();
        if (nums.length == 1) {
            ranges.add(nums[0] + "");
            return ranges;
        }
        
        for (int i=0; i<nums.length; i++) {
            int first = nums[i];
            while ((i+1 < nums.length) && (nums[i+1]-nums[i] == 1)) {
                i++;
            }
             if (first != nums[i]) {
                 ranges.add(first + "->" + nums[i]);
                 
             } else {
                 ranges.add(first + "");
             }
        }
        
        return ranges;
    }
}

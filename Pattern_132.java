/*
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], 
nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j]. Return true if there 
is a 132 pattern in nums, otherwise, return false.

Based on this solution:
https://leetcode.com/problems/132-pattern/discuss/525914/Java-count-from-end-and-use-Max-stack
Notes from author:
1, count from n-1 to 0;
2, use mid to store the mid value;
3, maintain a max stack to find the max mid.
4, find any next num that is lower than mid
*/

class Solution {
    public boolean find132pattern(int[] nums) {
        
        Stack<Integer> stk = new Stack<>();
        int midVal = Integer.MIN_VALUE;
        
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] < midVal)
                return true;
            
            while (!stk.isEmpty() && nums[i] > stk.peek()) 
                midVal = stk.pop();
            
            stk.push(nums[i]);
        }
        return false;
    }
}

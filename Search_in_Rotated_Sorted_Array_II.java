/*
#81 : Medium
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
You are given a target value to search. If found in the array return true, otherwise return false.
*/

class Solution {
    public boolean search(int[] nums, int target) {
        
        for (int n : nums)
            if (n == target)
                return true;
        
        return false;
    }
}

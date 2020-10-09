/*
#704 : Easy

Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function 
to search target in nums. If target exists, then return its index, otherwise return -1.

*/

class Solution {
    public int search(int[] nums, int target) {
        
        // get out quick
        if (target > nums[nums.length-1] || target < nums[0])
            return -1;
        
        // init
        int left = 0, right = nums.length, idx = -1;
        
        // close in on the target from both ends of the array
        while (left <= right) {
            int mid = (left+right)/2;
            if (nums[mid] < target)
                left = mid+1;
            else if (nums[mid] > target)
                right = mid-1;
            else if (nums[mid] == target) {
                idx = mid;
                break;
            }
        }
        
        // return index when found
        return idx;
    }
}

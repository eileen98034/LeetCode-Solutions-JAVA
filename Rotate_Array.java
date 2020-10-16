/*
#189: Medium
Given an array, rotate the array to the right by k steps, where k is non-negative.
Follow up:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
*/

class Solution {
    public void rotate(int[] nums, int k) {
        
        while (k > 0) {
            int[] temp = new int[nums.length];
            temp[0] = nums[nums.length-1];
            for (int i=1; i < nums.length; i++)
                temp[i] = nums[i-1];
            for (int i = 0; i < nums.length; i++)
                nums[i] = temp[i];
            k--;
        }
     }
}

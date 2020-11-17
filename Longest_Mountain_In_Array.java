/*
#845 : Medium
Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:
B.length >= 3
There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
(Note that B could be any subarray of A, including the entire array A.)
Given an array A of integers, return the length of the longest mountain. 
Return 0 if there is no mountain.
*/
class Solution {
    public int longestMountain(int[] A) {
        
        int longest = 0;
        int[] asc = new int[A.length],  desc = new int[A.length];
        
        for (int i = A.length-2; i >= 0; --i) 
            if (A[i] > A[i+1])
                desc[i] = desc[i+1]+1;
        
        for (int i = 0; i < A.length; ++i) {
            if (i>0 && A[i] > A[i-1])
                asc[i] = asc[i-1]+1;
        
            if (asc[i] > 0 && desc[i] > 0)
                longest = Math.max(longest,asc[i]+desc[i]+1);
        }
        
        return longest;
    }
}

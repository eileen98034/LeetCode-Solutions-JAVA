/*
#1007: Medium
In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the ith domino.  
(A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.) 
We may rotate the ith domino, so that A[i] and B[i] swap values.
Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.
If it cannot be done, return -1.
*/


class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        
        int dominoA=0, dominoB=0, rotations= -1;
        Map<Integer,Integer> dominoMap = new HashMap<>();
        
        for (int i = 0; i < A.length; i++) {
            dominoMap.put(A[i], dominoMap.getOrDefault(A[i],0)+1);
            if (B[i] != A[i]) {
                dominoMap.put(B[i], dominoMap.getOrDefault(B[i],0)+1);
            }
            if (dominoMap.get(A[i]) == A.length) 
                rotations = A[i];
            if (dominoMap.get(B[i]) == A.length) 
                rotations = B[i];
        }
        
        if (rotations == -1) 
            return -1;
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] != rotations) 
                dominoA++;
            if (B[i] != rotations)
                dominoB++;
        }
        
        return Math.min(dominoA,dominoB);
    }
}
        

/*
#832 : Easy
Given a binary matrix A, we want to flip the image horizontally, 
then invert it, and return the resulting image.
*/

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        
        int[][] fai = new int[A.length][A[0].length];
        
        for (int i = 0; i < A.length; i++) {
            for (int j = A[0].length-1, k=0; j >= 0 && k < A[0].length; j--,k++) 
                fai[i][k] = (A[i][j] ^= 1);  // invert and flip
        }
        
        return fai;
    }
}

/*
#74 : Medium

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
*/


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        for (int i = matrix.length-1; i >= 0; i--) {
            for (int j = matrix[i].length-1; j >= 0; j--) {
                if (matrix[i][j] == target)
                    return true;
            }
        }
        
        return false;
    }
}

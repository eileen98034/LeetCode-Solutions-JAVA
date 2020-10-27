/*
799 : Medium
*/


class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        
        double[][] rowsAndCols = new double[101][101];
        rowsAndCols[0][0] = poured;
        
        for (int row=0; row<=query_row; row++) {
            
            for (int col=0; col<=row; col++) {
                double output = (rowsAndCols[row][col]-1.0)/2;
                
                if (output > 0) {
                    rowsAndCols[row+1][col] += output;
                    rowsAndCols[row+1][col+1] += output;
                }
            }
        }
        
        return Math.min(1,rowsAndCols[query_row][query_glass]);
        
        
    }

}

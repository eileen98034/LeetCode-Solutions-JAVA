/*
#593 : Medium
Given the coordinates of four points in 2D space, return whether the four points could construct a square.
The coordinate (x,y) of a point is represented by an integer array with two integers.
*/

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> pointSet = new HashSet<>();
        
        pointSet.add(distance(p1,p2));
        pointSet.add(distance(p1,p3));
        pointSet.add(distance(p1,p4));
        pointSet.add(distance(p2,p3));
        pointSet.add(distance(p2,p4));
        pointSet.add(distance(p3,p4));
        
        return !pointSet.contains(0) && pointSet.size() == 2;
    }
    
    // distance between points
    private int distance (int[] pt1, int[]pt2) {
        return (pt1[0]-pt2[0]) 
            * (pt1[0]-pt2[0]) + (pt1[1]-pt2[1])
            * (pt1[1]-pt2[1]);
    }
}

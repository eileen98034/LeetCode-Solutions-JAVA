/*
#849: Medium

You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, 
and seats[i] = 0 represents that the ith seat is empty (0-indexed). There is at least one empty seat, and at least 
one person sitting. Alex wants to sit in the seat such that the distance between him and the closest person to him 
is maximized. Return that maximum distance to the closest person.
*/
class Solution {
    public int maxDistToClosest(int[] seats) {
        
        int dist = 0, cnt = -1;
        
        for (int i=0; i<seats.length; i++) {
            if (seats[i] == 1) {
                if (cnt < 0)
                    dist = i;
                else
                    dist = Math.max(dist,(i-cnt)/2);
                cnt = i;
            }
        }
        dist = Math.max(dist,seats.length-cnt-1);
        
        return dist;
    }
}

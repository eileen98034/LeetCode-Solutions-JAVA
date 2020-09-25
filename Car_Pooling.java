/*
#1094 Medium
You are driving a vehicle that has capacity empty seats initially available for passengers.  The vehicle only drives east (ie. it cannot turn around and drive west.)  
Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information about the i-th trip: the number of passengers that must be picked up, 
and the locations to pick them up and drop them off.  The locations are given as the number of kilometers due east from your vehicle's initial location.  Return true if 
and only if it is possible to pick up and drop off all passengers for all the given trips. 
*/

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        // if ever too many passengers, return false
        for (int i = 0; i < trips.length; i++) {
            if (trips[i][0] > capacity)
                return false;
        }
        
        // sort trips on start location
        Arrays.sort(trips, Comparator.comparingInt(trip -> trip[1]));
        
        // init
        int start=0, currCap=0, idx=0, len=trips.length; 
        
        // use PriorityQueue to keep track of destinations and distances
        Queue<int[]> tripQ = new PriorityQueue<>((j,k) -> j[2]-k[2]);
        while (idx < len) {
            
            while (!tripQ.isEmpty() && tripQ.peek()[2]<=trips[idx][1]) {
                currCap = currCap-tripQ.poll()[0];
            }
            
            // if over capacity return false
            if (currCap+trips[idx][0] > capacity) {
                return false;
            }
            
            currCap = currCap+trips[idx][0];
            tripQ.add(trips[idx++]);
        }
        
        return true;
    }
}

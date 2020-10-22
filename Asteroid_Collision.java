/*
#735 : Medium
We are given an array asteroids of integers representing asteroids in a row.
For each asteroid, the absolute value represents its size, and the sign represents 
its direction (positive meaning right, negative meaning left). Each asteroid moves 
at the same speed.  Find out the state of the asteroids after all collisions. If two 
asteroids meet, the smaller one will explode. If both are the same size, both will 
explode. Two asteroids moving in the same direction will never meet.
*/

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        LinkedList<Integer> asteroidLst = new LinkedList<>();
        
        int i=0;
        while (i < asteroids.length) {
            int a = asteroids[i];
            if (a > 0 || asteroidLst.isEmpty() || asteroidLst.getLast() < 0) {
                asteroidLst.add(a);
                i++;
                continue;
            }
            if (asteroidLst.getLast() <= -a) {
                if (asteroidLst.pollLast() == -a)
                    i++;
            }
            else
                i++;
        }
        
        return asteroidLst.stream().mapToInt(k -> k).toArray();
    }
}

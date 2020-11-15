/*
#458 : Hard
There are 1000 buckets, one and only one of them is poisonous, 
while the rest are filled with water. They all look identical. 
If a pig drinks the poison it will die within 15 minutes. What 
is the minimum amount of pigs you need to figure out which bucket 
is poisonous within one hour?
*/

class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        
        int min = 0;
        int t = minutesToTest/minutesToDie;
        while (Math.pow(t+1,min) < buckets)
            min++;
        
        return min;
    }
}

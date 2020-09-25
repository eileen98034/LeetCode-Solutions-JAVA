/*
#229 Medium
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
Note: The algorithm should run in linear time and in O(1) space.
*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> numLst = new ArrayList<>();
        Map<Integer,Integer> numMap = new HashMap<>();
       
        for (int n : nums)
            numMap.put(n, numMap.getOrDefault(n,0)+1);
        
        for(Map.Entry<Integer,Integer> numEntry : numMap.entrySet()) 
            if (numEntry.getValue() > nums.length/3)
                numLst.add(numEntry.getKey());
         
        return numLst;
     }
}

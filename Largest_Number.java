/*
#179: Medium
Given a list of non negative integers, arrange them such that they form the largest number.
*/

class Solution {
    public String largestNumber(int[] nums) {
        
        // init the return
        String numStr = "";
        
        // get out quick
        if (allZeros(nums))
            return "0";
        
        // convert int array to string array; compare strings
        String[] numArr = new String[nums.length];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = String.valueOf(nums[i]);
        }
        
        // sort strings using a comparator
        Arrays.sort(numArr, new Comparator<String>(){
            public int compare(String a, String b){
                return (b + a).compareTo(a + b);
            }
        });
        
        // write the return value
        for (int i = 0; i < numArr.length; i++)
            numStr += numArr[i];
 
        //return
        return numStr;
    }
    
    // check if array is all zeros
    private boolean allZeros (int[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] != 0)
                return false;
        return true;
    }
}

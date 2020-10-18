/*
#859 : Easy
Given two strings A and B of lowercase letters, return true if you can swap two letters 
in A so the result is equal to B, otherwise, return false.
*/

class Solution {
    public boolean buddyStrings(String A, String B) {
        
        // get out quick
        if (A.length() != B.length())
            return false;
        
        // if strings are equal, determine how many characters are duplicates
        if (A.equals(B)) {
            Set<Character> strA = new HashSet<>();
            for (char c : A.toCharArray())
                strA.add(c);
            return strA.size() < A.length();
        }
        
        // if strings are not equal, find how many differences there are
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < A.length(); ++i)
            if (A.charAt(i) != B.charAt(i))
                diff.add(i);
        
        // number of differences cannot exceed two
        return diff.size() == 2 
            && A.charAt(diff.get(0)) == B.charAt(diff.get(1)) 
            && A.charAt(diff.get(1)) == B.charAt(diff.get(0));
        
    }
}

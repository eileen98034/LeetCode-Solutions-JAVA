/*
#187 : Medium

All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T', for example: "ACGAATTCCG". When studying DNA, 
it is sometimes useful to identify repeated sequences within the DNA.  Write a function to find all the 10-letter-long sequences 
(substrings) that occur more than once in a DNA molecule.
*/
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        Set<String> test = new HashSet<>();
        Set<String> repeats = new HashSet<>();
        
        for (int i = 0; i+9 < s.length(); i++) {
            String sequence = s.substring(i, i+10);
            if (!test.add(sequence))
                repeats.add(sequence);
        }
        
        return new ArrayList(repeats);
        
    }
}

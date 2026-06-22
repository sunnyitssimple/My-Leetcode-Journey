class Solution {
    public int rearrangeCharacters(String s, String target) {
        // Frequency arrays for 's' and 'target'
        int[] sCounts = new int[26];
        int[] targetCounts = new int[26];
        
        // Count frequencies in source string s
        for (int i = 0; i < s.length(); i++) {
            sCounts[s.charAt(i) - 'a']++;
        }
        
        // Count frequencies in target string
        for (int i = 0; i < target.length(); i++) {
            targetCounts[target.charAt(i) - 'a']++;
        }
        
        int maxCopies = Integer.MAX_VALUE;
        
        // Find the limiting bottleneck character
        for (int i = 0; i < 26; i++) {
            if (targetCounts[i] > 0) {
                // Available letters divided by required letters per copy
                int possibleCopies = sCounts[i] / targetCounts[i];
                maxCopies = Math.min(maxCopies, possibleCopies);
            }
        }
        
        return maxCopies;
    }
}

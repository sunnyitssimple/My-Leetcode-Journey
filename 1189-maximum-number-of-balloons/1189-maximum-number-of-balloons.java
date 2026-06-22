class Solution {
    public int maxNumberOfBalloons(String text) {
        // Frequency array for all 26 lowercase English letters
        int[] counts = new int[26];
        
        // Count frequencies of each character in the text
        for (int i = 0; i < text.length(); i++) {
            counts[text.charAt(i) - 'a']++;
        }
        
        // Find the limiting character bottleneck
        int bCount = counts['b' - 'a'];
        int aCount = counts['a' - 'a'];
        int lCount = counts['l' - 'a'] / 2; // Requires 2 'l's per word
        int oCount = counts['o' - 'a'] / 2; // Requires 2 'o's per word
        int nCount = counts['n' - 'a'];
        
        // Return the minimum possible number of complete words
        return Math.min(bCount, 
               Math.min(aCount, 
               Math.min(lCount, 
               Math.min(oCount, nCount))));
    }
}

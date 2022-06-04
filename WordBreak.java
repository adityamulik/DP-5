
class WordBreak {
		/*
     * The solution is brute force and it works but for larger string it fails
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        
        if (s.length() == 0 || s == null) return true;
        
        HashSet<String> set = new HashSet<>(wordDict);
        
        return helper(s, set);
    }
    
    private boolean helper(String s, HashSet<String> set) {
        
        // base case
        if (s.length() == 0) return true;
        
        // logic
        
        for (int i=0; i<s.length(); i++) {
            if (set.contains(s.substring(0, i+1)) && helper(s.substring(i+1), set)) {
                return true;
            }
        }
        
        return false;
    }


    // DP Solution
    
    public boolean wordBreakDP(String s, List<String> wordDict) {
        
        /*
         * Time Complexity: O(n**3) as first loop for i, second for j and third for substring
         * Space Complexity: O(n) as each character's boolean value array is created + 1
         *
         */
        
        if (s.length() == 0 || s == null) return true;
        
        HashSet<String> set = new HashSet<>(wordDict);
        
        boolean[] dp = new boolean[s.length() + 1];
        
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j]) {
                    String sub = s.substring(j, i);
                    if (set.contains(sub)) {
                        dp[i] = true;
                    }   
                }                
            }
        }
        
        return dp[s.length()];
    }
}

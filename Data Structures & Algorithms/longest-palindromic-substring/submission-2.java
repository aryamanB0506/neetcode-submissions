class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int longestStart = 0;
        int longestEnd = 0;
        int longestLength = 0;
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = true;
        }
        for(int i = 1; i < s.length()-1; i++){
            for(int j = 1; j < s.length(); j++){
                if(i-j>=0 && i+j < s.length()){
                    if(dp[i-j+1][i+j-1] && s.charAt(i-j)==s.charAt(i+j)){
                        dp[i-j][i+j] = true;
                        if(longestLength < ((i+j)-(i-j))){
                            longestStart = i-j;
                            longestEnd = i+j;
                            longestLength = ((i+j)-(i-j));
                        }
                    }
                    else{
                        dp[i-j][i+j] = false;
                        break;
                    }
                }
                else{
                    break;
                }
            }
        }
        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                if(longestLength < 2){
                    longestStart = i;
                    longestEnd = i+1;
                    longestLength = 2;
                }
            }
        }
        for(int i = 1; i < s.length()-2; i++){
            for(int j = 1; j < s.length(); j++){
                if(i-j>=0 && i+j+1 < s.length()){
                    if(dp[i-j+1][i+j] && s.charAt(i-j)==s.charAt(i+j+1)){
                        dp[i-j][i+j+1] = true;
                        if(longestLength < ((i+j+1)-(i-j))){
                            longestStart = i-j;
                            longestEnd = i+j+1;
                            longestLength = ((i+j+1)-(i-j));
                        }
                    }
                    else{
                        dp[i-j][i+j+1] = false;
                        break;
                    }
                }
                else{
                    break;
                }
            }
        }
        return s.substring(longestStart,longestEnd+1);
    }
}

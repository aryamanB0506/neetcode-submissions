class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = true;
            count++;
        }
        for(int i = 1; i < s.length()-1; i++){
            for(int j = 1; j < s.length(); j++){
                if(i-j>=0 && i+j < s.length()){
                    if(dp[i-j+1][i+j-1] && s.charAt(i-j)==s.charAt(i+j)){
                        dp[i-j][i+j] = true;
                        count++;
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
                count++;
            }
        }
        for(int i = 1; i < s.length()-2; i++){
            for(int j = 1; j < s.length(); j++){
                if(i-j>=0 && i+j+1 < s.length()){
                    if(dp[i-j+1][i+j] && s.charAt(i-j)==s.charAt(i+j+1)){
                        dp[i-j][i+j+1] = true;
                        count++;
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
        return count;
    }
}

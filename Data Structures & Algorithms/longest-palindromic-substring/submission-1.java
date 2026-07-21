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
                //System.out.println("Checking for " + i + ", " + j);
                //System.out.println("Start is " + (i-j) + " end is " + (i+j));
                if(i-j>=0 && i+j < s.length()){
                    //System.out.println("Valid indices");
                    if(dp[i-j+1][i+j-1] && s.charAt(i-j)==s.charAt(i+j)){
                        //System.out.println("Matching, extending");
                        dp[i-j][i+j] = true;
                        if(longestLength < ((i+j)-(i-j))){
                            longestStart = i-j;
                            longestEnd = i+j;
                            longestLength = ((i+j)-(i-j));
                            //System.out.println("Longest of " + longestLength + " from " + longestStart + " " + longestEnd);
                        }
                    }
                    else{
                        dp[i-j][i+j] = false;
                    }
                }
                else{
                    break;
                }
            }
        }
        //System.out.println("Switching to even length");
        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                if(longestLength < 2){
                    longestStart = i;
                    longestEnd = i+1;
                    longestLength = 2;
                    //System.out.println("Longest of " + longestLength + " from " + longestStart + " " + longestEnd);
                }
            }
        }
        for(int i = 1; i < s.length()-2; i++){
            for(int j = 1; j < s.length(); j++){
                //System.out.println("Checking for " + i + ", " + j);
                //System.out.println("Start is " + (i-j) + " end is " + (i+j+1));
                if(i-j>=0 && i+j+1 < s.length()){
                    //System.out.println("Valid indices");
                    if(dp[i-j+1][i+j] && s.charAt(i-j)==s.charAt(i+j+1)){
                        //System.out.println("Matching, extending");
                        dp[i-j][i+j+1] = true;
                        if(longestLength < ((i+j+1)-(i-j))){
                            longestStart = i-j;
                            longestEnd = i+j+1;
                            longestLength = ((i+j+1)-(i-j));
                            //System.out.println("Longest of " + longestLength + " from " + longestStart + " " + longestEnd);
                        }
                    }
                    else{
                        dp[i-j][i+j+1] = false;
                    }
                }
                else{
                    break;
                }
            }
        }
        //System.out.println("Returning from " + longestStart + " " + longestEnd);
        return s.substring(longestStart,longestEnd+1);
    }
}

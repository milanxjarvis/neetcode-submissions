class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n==0) return "";
        boolean[][] dp=new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        int start=0,maxLen=1;
        for(int length=2;length<=n;length++){
            for(int i=0;i<=n-length;i++){
                int j=i+length-1;
                if(s.charAt(i)==s.charAt(j)){
                    if(length==2 ||dp[i+1][j-1]){
                        dp[i][j]=true;
                        if(length>maxLen){
                            start=i;
                            maxLen=length;
                        }
                    }
                }
            }
        }
        return s.substring(start,start+maxLen);
    }
}

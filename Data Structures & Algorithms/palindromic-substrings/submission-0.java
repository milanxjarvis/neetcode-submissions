class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        if(n==0) return 0;
        boolean[][] dp=new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        int palindrome=n;
        for(int length=2;length<=n;length++){
            for(int i=0;i<=n-length;i++){
                int j=i+length-1;
                 if(s.charAt(i)==s.charAt(j)){
                    if(length==2 || dp[i+1][j-1]){
                        dp[i][j]=true;
                        palindrome++;
                    }
                 }
            }
        }
        return palindrome;
    }
}

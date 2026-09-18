class Solution {
    public int numDecodings(String s) {
        int[] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return solve(0,s,dp);
    }
    private int solve(int index,String s,int[] dp){
        if(index==s.length()) return 1;
        if(s.charAt(index)=='0') return 0;
        if(dp[index]!=-1) return dp[index];
        int ways=solve(index+1,s,dp);
        if(index+1<s.length()){
            int num=(s.charAt(index)-'0')*10+(s.charAt(index+1)-'0');
            if(num>=10 && num<=26){
                ways+=solve(index+2,s,dp);
            }
        }
        dp[index]=ways;
        return ways;
    }
}

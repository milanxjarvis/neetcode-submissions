class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[] dp=new int[amount+1];
        int[] current=new int[amount+1];
        for(int a=0;a<=amount;a++){
            if(a%coins[0]==0){
                dp[a]=1;
            }
        }
        for(int i=1;i<n;i++){
            current[0]=1;
            for(int a=1;a<=amount;a++){
                
                int skip=dp[a];
                int take=0;
                if(a>=coins[i]){
                    take=current[a-coins[i]];
                }
                current[a]=skip+take;
            }
            dp=current;
        }
        return dp[amount];
    }
}

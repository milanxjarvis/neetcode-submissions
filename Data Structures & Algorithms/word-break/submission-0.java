class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo=new Boolean[s.length()];
        return dfs(s,wordDict,memo,0);
    }
    private boolean dfs(String s,List<String> wordDict,Boolean[] memo,int i){
        if(i==s.length()){
            return true;
        }
        if(memo[i]!=null) return memo[i];
        for(String w:wordDict){
            if(i+w.length()<=s.length() && s.substring(i,i+w.length()).equals(w)){
                if(dfs(s,wordDict,memo,i+w.length())){
                   return memo[i]=true;
                }
            }
        }
        return memo[i]=false;
    }
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {
      if(s1.length()>s2.length()){
            return false;
        }
        int[] count=new int[26];
        int[] windowCount=new int[26];

        for(int i=0;i<s1.length();i++){
            count[s1.charAt(i)-'a']++;
            windowCount[s2.charAt(i)-'a']++;
        }
     int matches=0;
        for(int i=0;i<26;i++){
        if( count[i]==windowCount[i]) matches++;
        }
        int l=0;
        for(int r=s1.length();r<s2.length();r++){
            if(matches==26){
                return true;
            }
            int idx=s2.charAt(r)-'a';
            windowCount[idx]++;
            if(count[idx]==windowCount[idx]) matches++;
            else if(count[idx]==windowCount[idx]-1) matches--;
            int idx2=s2.charAt(l)-'a';
            windowCount[idx2]--;
            if(windowCount[idx2]==count[idx2]) matches++;
            else if (windowCount[idx2]+1==count[idx2]) matches--;
                
            
            l++;
        }
        return matches==26;   
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String minStr = strs[0];
        
        for(int i=1; i<strs.length; i++){
            if(minStr.length() >= strs[i].length()){
                minStr = strs[i];
            }
        }

        
        for(int i=minStr.length(); i>0; i--){
            boolean flag = true;
            String currString = minStr.substring(0, i);
            for(String item : strs){
                if(!item.startsWith(currString)) {
                    flag = false;
                }
            }

            if(flag){
                return minStr.substring(0, i);
            }

        }

        return "";
    }
}
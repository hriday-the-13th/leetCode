class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int start = 0; 
        int end = 0;
        int maxLength = 0;


        while(end<s.length()){
            while (charSet.contains(s.charAt(end))) {
                charSet.remove(s.charAt(start));
                start++;
            }

            charSet.add(s.charAt(end));
            maxLength = Math.max(maxLength, charSet.size());
            end++;
        }

        return maxLength;
    }
}
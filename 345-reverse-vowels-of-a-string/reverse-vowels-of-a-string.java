class Solution {
    public String reverseVowels(String s) {
        int start = 0; 
        int end = s.length()-1;

        char[] charArr = s.toCharArray();
        String vowels = "aeiouAEIOU";
        while(start<end){
            while (start < end && vowels.indexOf(charArr[start]) == -1) {
                start++;
            }

            while (start < end && vowels.indexOf(charArr[end]) == -1) {
                end--;
            }


            char temp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = temp;

            start++;
            end--;

        }

        return new String(charArr);
    }
}
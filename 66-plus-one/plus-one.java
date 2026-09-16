class Solution {
    public int[] plusOne(int[] digits) {
        return addOne(digits, digits.length - 1);
    }

    public int[] addOne(int[] digits, int idx){
        if(idx<0){
            return digits;
        }

        if(digits[idx] != 9){
            digits[idx] = digits[idx] + 1;
        } else {
            if(idx == 0){
                digits[idx] = 0;
                int[] newArr = new int[digits.length + 1];
                newArr[0] = 1;
                for(int i=0; i<digits.length; i++){
                    newArr[i+1] = digits[i];
                }
                return newArr;
            } else {
                digits[idx] = 0;
                return addOne(digits, idx - 1);
            }
        }

        return digits;

    }



}
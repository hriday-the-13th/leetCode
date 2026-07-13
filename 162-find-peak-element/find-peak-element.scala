object Solution {
    def findPeakElement(nums: Array[Int]): Int = {
        var peak = Int.MinValue
        if(nums.length == 1){
            return 0
        }

        for(i <- 1 until nums.length-1){
            if(nums(i-1) < nums(i) && nums(i) > nums(i+1)){
                peak = i
            }
        }

        if(peak == Int.MinValue && nums(0) > nums(1)){
            peak = 0
        }

        if(peak == Int.MinValue && nums(nums.length-1) > nums(nums.length-2)){
            peak = nums.length-1
        }

        peak
    }
}
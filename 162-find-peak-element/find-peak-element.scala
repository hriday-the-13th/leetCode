object Solution {

    def findPeakElement(nums: Array[Int]): Int = {
        if(nums.length == 1){
            return 0
        }

        if(nums(0) > nums(1)){
            return 0
        }

        if(nums(nums.length-1) > nums(nums.length-2)){
            return nums.length-1
        }

        def binary(start: Int, end: Int): Int = {
            if(start>end) return -1
            val mid = (start + end) / 2 

            if(nums(mid) > nums(mid-1) && nums(mid) > nums(mid + 1)){
                return mid
            }

            if(nums(mid)>nums(mid-1)){
                binary(mid+1, end)
            } else {
                binary(start, mid-1)
            }
        }

        binary(1, nums.length-2)
    }
    //brute force
    // def findPeakElement(nums: Array[Int]): Int = {
    //     var peak = -1
    //     if(nums.length == 1){
    //         return 0
    //     }

    //     for(i <- 1 until nums.length-1){
    //         if(nums(i-1) < nums(i) && nums(i) > nums(i+1)){
    //             peak = i
    //         }
    //     }

    //     if(peak == -1 && nums(0) > nums(1)){
    //         peak = 0
    //     }

    //     if(peak == -1 && nums(nums.length-1) > nums(nums.length-2)){
    //         peak = nums.length-1
    //     }

    //     peak
    // }
}